package org.ohx.studyjuc.streamcommunication.pipereaderwriter;

import java.io.IOException;
import java.io.PipedReader;

/**
 * @author mudkip
 * @date 2022/6/25
 */
public class ReadData {
    public void readMethod(PipedReader in) {
        try {
            System.out.println("read: ");
            char[] chars = new char[20];
            int readLength = in.read(chars);
            while (readLength != -1) {
                String newData = new String(chars, 0, readLength);
                System.out.print(newData);
                readLength = in.read(chars);
            }
            System.out.println();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
