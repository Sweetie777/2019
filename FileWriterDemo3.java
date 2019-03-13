package com.bittech.review.test.fileWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 对已有文件的数据续写
 * Author: Sweetie77
 * Created: 2019/3/13
 */
public class FileWriterDemo3 {
    public static void main(String[] args) throws IOException {

        //传递一个true参数, 代表不覆盖已有文件, 并在已有文件的末尾进行数据续写
        FileWriter fw = new FileWriter("demo.txt",true);
        fw.write("nihao\r\nxiexie");//在windows中 \r\n 是换行符
        fw.close();
    }
}
