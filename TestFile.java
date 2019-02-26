package com.bittech.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Author: Sweetie77
 * Created: 2019/2/26
 */
public class TestFile {

    public static void code1() {
        File file = new File("D:" + File.separator + "a" + File.separator + "b" + File.separator + "test.txt");
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            //D:\a
            //D:\a\b
            if (!parentFile.exists()) {
                //只会创建当前目录
//                if (parentFile.mkdir()) {
//                    System.out.println("创建目录成功");
//                }
                //会创建目录以及上级目录（如果不存在）
                if (parentFile.mkdirs()) {
                    System.out.println("创建目录成功");
                }
            }
            try {
                if (file.createNewFile()) {
                    System.out.println("文件创建成功");
                } else {
                    System.out.println("文件创建失败");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void code2() {
        //        File file = new File("D:" + File.separator + "test" + File.separator + "file_info.txt");

        File file = new File("D:" + File.separator + "test");

        System.out.println("文件是否是目录：" + file.isDirectory());
        System.out.println("文件是否是普通文件：" + file.isFile());
        System.out.println("文件大小：" + file.length());
        System.out.println("文件最后修改时间：" +
                new Date(file.lastModified()));

    }


    public static void code3() {
        File file = new File("D:" + File.separator + "test");

        //String[] fileNames = file.list();
        //file 是普通文件返回null, 如果是目录返回目录下的所有文件以及文件夹
//        File[] files = file.listFiles();
//        if (files != null) {
//            for (File f : files) {
//                // System.out.println(f.getName());
//                System.out.println(f.getAbsolutePath());
//            }
//        }

        if (file.exists() && file.isDirectory()) {
            for (File f : file.listFiles()) {
                System.out.println(f.getAbsolutePath());
            }
        }
    }

    public static void code4() {
        //D:\test
        Path path = Paths.get("D:", "test");
        //D:\test\file_info.txt
        Path path1 = Paths.get("D:", "test", "file_info.txt");
        //D:
        Path path2 = Paths.get("D:");

        File file = path.toFile();
        File file1 = Paths.get("D:", "test").toFile();

        //File -> new File("...")
        //Path -> Paths.get("..") .toFile()
        //java.nio.file

        try {
            //Files
            Files.delete(path1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {




    }

    //通过递归方式遍历指定文件目录下的所有文件以及子目录
    public static void findFile(File file, int level) {
        if (file.isFile()) {
            System.out.println("|" + repeatSpace(level) + "|-" + file.getName());
        } else {
            System.out.println(repeatSpace(level) + "+" + file.getName());
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    findFile(f, level + 2);
                }
            }
        }
    }

    private static String repeatSpace(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
