package com.bittech.review.test.fileWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Author: Sweetie77
 * Created: 2019/3/13
 */
public class FileWriterDemo {

    public static void main(String[] args) {
        //创建一个FileWriter对象, 该对象一被初始化就要明确被操作的文件
        //而且 该文件会被创建在指定目录下, 如果该目录下已有同名文件, 将被覆盖,
        //其实该步就是在明确数据要存放的目的地
        FileWriter fw = null;
        try {
            fw = new FileWriter("demo.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //调用writer方法, 将字符串写入到流中
        try {
            fw.write("abc");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //刷新流对象中的缓冲中的数据
        //将数据刷到目的地中
        try {
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //关闭流资源,但是关闭之前会刷新一次内部的缓冲中的数据
        //将数据刷到目的地中
        //和flush区别: 刷新后, 流可以使用, close后, 流关闭
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
