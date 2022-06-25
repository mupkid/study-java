package org.ohx.studyjuc.streamcommunication.pipeinputoutput;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class ReadData {
    public void readMethod(PipedInputStream in) {
        try {
            System.out.println("read: ");
            byte[] bytes = new byte[20];
            int readLength = in.read(bytes);
            while (readLength != -1) {
                String newData = new String(bytes, 0, readLength);
                System.out.print(newData);
                readLength = in.read(bytes);
            }
            System.out.println();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
