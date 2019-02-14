package com.bittech.tfdp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

/**
 * Author: secondriver
 * Created: 2018/12/7
 */
public class TestCharStream {

    public static void write() {
        File file = Paths.get("D:", "test", "java6.txt").toFile();
        try (Writer writer = new FileWriter(file)) {
            writer.write("Hello I 老虎 U ！!");
            writer.write("HelloWorld");
            writer.write(new char[]{'A', 'B', 'C', '\n'});
            writer.write(new char[]{'a', 'b', 'c'}, 2, 1);
            /*
            Hello I 老虎 U ！!HelloWorldABC
            c
             */
        } catch (IOException e) {

        }
    }


    public static void reader() {
        File file = Paths.get("D:", "test", "java6.txt").toFile();
        try (FileReader reader = new FileReader(file)) {
            char[] buffer = new char[10];
            int len = -1;
            while ((len = reader.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }
        } catch (IOException e) {

        }
    }

    public static void code2() {
        File file = Paths.get("D:", "test", "java6.txt").toFile();
        try (Writer writer = new FileWriter(file)) {
            writer.write("Hello I 老虎 U ！!");
            writer.write("HelloWorld");
            writer.flush();//缓冲区的内容输出到目的地
            writer.write(new char[]{'A', 'B', 'C', '\n'});
            writer.write(new char[]{'a', 'b', 'c'}, 2, 1);
            writer.flush();
        } catch (IOException e) {

        }
        //JavaEE web编程 Servlet flush
    }

    public static void code3() {
        File file = Paths.get("D:", "test", "outputstreamwriter.txt").toFile();
        //通过字节流构造字符流对象，注意编码格式
        //字节流
        try (FileOutputStream out = new FileOutputStream(file);
             //字符流
             OutputStreamWriter writer = new OutputStreamWriter(out)
        ) {
            writer.write("HelloWorld");
            writer.write("比特科技");
        } catch (IOException e) {

        }
    }

    public static void main(String[] args) {
//        System.getProperties().list(System.out);
        File file = Paths.get("D:", "test", "encoding_error.txt").toFile();
        //通过字节流构造字符流对象，注意编码格式
        //字节流
        try (FileOutputStream out = new FileOutputStream(file);
        ) {
            //统一采用UTF-8
            //ISO-8859-1
            out.write("比特科技".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {

        }
        //javac -encoding UTF-8

    }
}
