package org.ohx.studyjuc.streamcommunication.pipeinputoutput;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.TimeUnit;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class Run {
    public static void main(String[] args) throws IOException, InterruptedException {
        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        pipedOutputStream.connect(pipedInputStream);

        new Thread(() -> {
            readData.readMethod(pipedInputStream);
        }).start();

        TimeUnit.SECONDS.sleep(2);

        new Thread(() -> {
            writeData.writeMethod(pipedOutputStream);
        }).start();
    }
}
