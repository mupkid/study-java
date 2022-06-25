package org.ohx.studyjuc.streamcommunication.pipereaderwriter;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class Run {
    public static void main(String[] args) throws IOException, InterruptedException {
        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();
        PipedReader pipedReader = new PipedReader();
        PipedWriter pipedWriter = new PipedWriter();
        pipedWriter.connect(pipedReader);

        new Thread(() -> {
            readData.readMethod(pipedReader);
        }).start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(() -> {
            writeData.writeMethod(pipedWriter);
        }).start();
    }
}
