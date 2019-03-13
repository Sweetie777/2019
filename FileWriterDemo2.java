package com.bittech.review.test.fileWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * I/O异常处理方式
 * Author: Sweetie77
 * Created: 2019/3/13
 */
public class FileWriterDemo2 {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("demo.txt");
            fw.write("abcdef");

        } catch (IOException e) {
            System.out.println("catch:" + e.toString());
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    System.out.println(e.toString());
                }
            }
        }
    }

}
