package com.bittech.tfdp;

/**
 * Author: Sweetie77
 * Created: 2019/2/15
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class TestInputStream {

    public static void code1() {
        //字节输入流和输出流的缓存方式读取和写入
        File file = Paths.get("D:", "test", "test.txt").toFile();
        File destFile = Paths.get("D:", "test", "test2.txt").toFile();
        try (FileInputStream in = new FileInputStream(file);
             FileOutputStream out = new FileOutputStream(destFile)
        ) {
            byte[] buff = new byte[3];
            int len = -1;
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
        } catch (IOException e) {

        }
    }

}

    //文件复制
    public static void copy(String srcFilePath, String destFilePath) {
        //参数校验
        if (srcFilePath == null || srcFilePath.isEmpty()) {
            throw new IllegalArgumentException("srcFilePath must be not null/empty");
        }
        if (destFilePath == null || destFilePath.isEmpty()) {
            throw new IllegalArgumentException("destFilePath must be not null/empty");
        }

        //文件校验以及准备工作
        File srcFile = Paths.get(srcFilePath).toFile();
        File destFile = Paths.get(destFilePath).toFile();

        if (!srcFile.exists() || !srcFile.isFile()) {
            throw new IllegalArgumentException("srcFilePath file not exists or not file");
        }

        File parentFile = destFile.getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs()) {
                throw new RuntimeException("can't create " + parentFile.getAbsolutePath() + " directory");
            }
        }

        //文件复制
        try (FileInputStream in = new FileInputStream(srcFile);
             FileOutputStream out = new FileOutputStream(destFile)
        ) {
            //缓存数组
            byte[] buff = new byte[1024]; //1k , 2k, 4k, 8k
            int len = -1;
            while ((len = in.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void testCopy() {
        String src = "D:\\__download\\VirtualBox-5.2.22-126460-Win.exe";
        String dest = "D:\\__download\\vbox\\VirtualBox-5.2.22-126460-Win.exe";
        long start = System.currentTimeMillis();
        copy(src, dest);
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000 + " s");
    }

    public static void main(String[] args) {


    }
}
