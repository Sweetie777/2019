package com.bittech.tfdp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;

/**
 * Author: secondriver
 * Created: 2018/12/7
 */

public class DesignPrintStream {

    private OutputStream outputStream;

    public DesignPrintStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void print(String str) {
        try {
            outputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String str) {
        print(str);
        try {
            outputStream.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(int value) {
        println(String.valueOf(value));
    }

    public void println(double value) {
        println(String.valueOf(value));
    }

    public void println(boolean value) {
        println(String.valueOf(value));
    }

    public static void main(String[] args) {

//        DesignPrintStream print = new DesignPrintStream(System.out);

        DesignPrintStream print = null;
        try {
            print = new DesignPrintStream(
                    new FileOutputStream(Paths.get("D:", "test", "print.txt").toFile())
            );
            print.println("HelloWorld");
            print.println(10);
            print.println(10.0D);
            print.println(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}

