package com.bittech.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;

/**
 * Author: Sweetie77
 * Created: 2019/3/3
 */


public class TestByteStream {

    //1.输入流：
    //  1.1 准备文件
    //  1.2 实例化FileInputStream对象
    //  1.3 read()读取数据
    //  1.4 业务处理处理
    //  1.5 关闭输入流-finally

    //2.输出流：
    //  2.1 准备文件，文件不存在自动创建，但是目录一定要存在
    //  2.2 实例化FileOutputStream对象
    //  2.3 业务处理数据
    //  2.4 write() 输出数据
    //  2.4 关闭输出流-finally

    //3.业务处理
    //  3.1 读取数据，while(){} ，读到末尾返回-1

    public static void code1() {
        // input.txt -> application -> output.txt
        File inputFile = Paths.get("D:", "test", "input.txt").toFile();
        File outputFile = Paths.get("D:", "test", "output.txt").toFile();
        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }
        FileInputStream ins = null;
        FileOutputStream out = null;
        try {
            ins = new FileInputStream(inputFile);
            out = new FileOutputStream(outputFile);
            int value = -1;
            //输入
            while ((value = ins.read()) != -1) {
                //程序中进行数据的处理
                value = value + 32; //A-a
                //输出
                out.write(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭数据流
            if (ins != null) {
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void code2() {
        File file = Paths.get("D:", "test", "java6.txt").toFile();
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write(65);
            byte[] data = new byte[]{65, 66, 67};
            out.write(data);
            out.write(data, 2, 1);
            out.write('\n');
            String message = "java6 666 !";
            out.write(message.getBytes());

        } catch (IOException e) {

        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    //输出流采用自动关闭
    public static void code3() {
        File file = Paths.get("D:", "test", "java6.txt").toFile();
        try (OutputStream out = new FileOutputStream(file);
        ) {
            out.write(65);
            byte[] data = new byte[]{65, 66, 67};
            out.write(data);
            out.write(data, 2, 1);
            out.write('\n');
            String message = "java6 666 !";
            out.write(message.getBytes());
        } catch (IOException e) {
        }
    }

    public static void main(String[] args) {


    }

}
