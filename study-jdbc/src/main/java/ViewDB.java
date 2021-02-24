import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ViewDB {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ViewDBFrame();
            frame.setTitle("ViewDB");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ViewDBFrame extends JFrame {
    private JButton previousButton;
    private JButton nextButton;
    private JButton deleteButton;
    private JButton saveButton;
    private DataPanel dataPanel;
    private Component scrollPane;
    private JComboBox<String> tableNames;
    private Properties properties;
    private CachedRowSet cachedRowSet;
    private Connection connection;

    public ViewDBFrame() {
        tableNames = new JComboBox<>();
        try {
            readDatabaseProperties();
            connection = getConnection();
            DatabaseMetaData metaData = connection.getMetaData();
            try (ResultSet resultSet = metaData.getTables(null, null, null, new String[]{"TABLE"})) {
                while (resultSet.next()) {
                    tableNames.addItem(resultSet.getString(3));
                }
            }
        } catch (SQLException throwables) {
            for (Throwable t : throwables) {
                t.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        tableNames.addActionListener(
                event -> showTable((String) tableNames.getSelectedItem(), connection)
        );
        add(tableNames, BorderLayout.NORTH);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException throwables) {
                    for (Throwable t : throwables) {
                        t.printStackTrace();
                    }
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);
        previousButton = new JButton("Previous");
        previousButton.addActionListener(event -> showPreviousRow());
        buttonPanel.add(previousButton);

        nextButton = new JButton("Next");
        nextButton.addActionListener(event -> showNextRow());
        buttonPanel.add(nextButton);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(event -> deleteRow());
        buttonPanel.add(deleteButton);

        saveButton = new JButton("Save");
        saveButton.addActionListener(event -> saveChanges());
        buttonPanel.add(saveButton);

        if (tableNames.getItemCount() > 0) {
            showTable(tableNames.getItemAt(0), connection);
        }
    }

    public void showTable(String tableName, Connection connection) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM " + tableName)) {
            RowSetFactory factory = RowSetProvider.newFactory();
            cachedRowSet = factory.createCachedRowSet();
            cachedRowSet.setTableName(tableName);
            cachedRowSet.populate(resultSet);
            if (scrollPane != null) {
                remove(scrollPane);
            }
            dataPanel = new DataPanel(cachedRowSet);
            scrollPane = new JScrollPane(dataPanel);
            add(scrollPane, BorderLayout.CENTER);
            pack();
            showNextRow();
        } catch (SQLException throwables) {
            for (Throwable t : throwables) {
                t.printStackTrace();
            }
        }
    }

    public void showPreviousRow() {
        try {
            if (cachedRowSet == null || cachedRowSet.isFirst()) {
                return;
            }
            cachedRowSet.previous();
            dataPanel.showRow(cachedRowSet);
        } catch (SQLException throwables) {
            for (Throwable t : throwables) {
                t.printStackTrace();
            }
        }
    }

    public void showNextRow() {
        try {
            if (cachedRowSet == null || cachedRowSet.isLast()) {
                return;
            }
            cachedRowSet.next();
            dataPanel.showRow(cachedRowSet);
        } catch (SQLException throwables) {
            for (Throwable t : throwables) {
                t.printStackTrace();
            }
        }
    }

    public void deleteRow() {
        if (cachedRowSet == null) {
            return;
        }
        new SwingWorker<Void, Void>() {
            @Override
            public Void doInBackground() throws SQLException {
                cachedRowSet.deleteRow();
                cachedRowSet.acceptChanges(connection);
                if (cachedRowSet.isAfterLast()) {
                    if (!cachedRowSet.last()) {
                        cachedRowSet = null;
                    }
                }
                return null;
            }

            @Override
            public void done() {
                dataPanel.showRow(cachedRowSet);
            }
        }.execute();
    }

    public void saveChanges() {
        if (cachedRowSet == null) {
            return;
        }
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws SQLException {
                dataPanel.setRow(cachedRowSet);
                cachedRowSet.acceptChanges(connection);
                return null;
            }
        }.execute();
    }

    public void readDatabaseProperties() throws IOException {
        properties = new Properties();
        try (InputStream inputStream = Files.newInputStream(Paths.get("/classpath://database.properties"))) {
            properties.load(inputStream);
        }
        String drivers = properties.getProperty("jdbc.drivers");
        if (drivers != null) {
            System.setProperty("jdbc.drivers", drivers);
        }
    }

    private Connection getConnection() throws SQLException {
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        return DriverManager.getConnection(url, username, password);
    }
}

class DataPanel extends Panel {
    private List<JTextField> fieldList;

    public DataPanel(RowSet rowSet) throws SQLException {
        fieldList = new ArrayList<>();
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;

        ResultSetMetaData resultSetMetaData = rowSet.getMetaData();
        for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
            gridBagConstraints.gridy = i - 1;
            String columnName = resultSetMetaData.getColumnLabel(i);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.anchor = GridBagConstraints.EAST;
            add(new JLabel(columnName), gridBagConstraints);

            int columnWidth = resultSetMetaData.getColumnDisplaySize(i);
            JTextField textField = new JTextField(columnWidth);
            if (!resultSetMetaData.getColumnClassName(i).equals("java.lang.String")) {
                textField.setEditable(false);
            }
            fieldList.add(textField);
            gridBagConstraints.gridx = 1;
            gridBagConstraints.anchor = GridBagConstraints.WEST;
            add(textField, gridBagConstraints);
        }
    }

    public void showRow(ResultSet resultSet) {
        try {
            if (resultSet == null) {
                return;
            }
            for (int i = 1; i <= fieldList.size(); i++) {
                String field = resultSet.getString(i);
                JTextField textField = fieldList.get(i - 1);
                textField.setText(field);
            }
        } catch (SQLException throwables) {
            for (Throwable t : throwables) {
                t.printStackTrace();
            }
        }
    }

    public void setRow(RowSet rowSet) throws SQLException {
        for (int i = 1; i <= fieldList.size(); i++) {
            String field = rowSet.getString(i);
            JTextField textField = fieldList.get(i - 1);
            if (!field.equals(textField.getText())) {
                rowSet.updateString(i, textField.getText());
            }
        }
        rowSet.updateRow();
    }

}