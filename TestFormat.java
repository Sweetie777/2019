package com.bittech.tfdp;

/**
 * Author: Sweetie77
 * Created: 2019/2/15
 */

public class TestFormat {

    public static void code1() {

        System.out.println("");
        System.out.print("");
//        System.out.printf("%s","hello");
        System.out.printf("姓名：%s, 年龄：%d, 身高：%f", "张三", 28, 168.7D);
        System.out.printf("姓名：%s, 年龄：%d, 身高：%.2f", "张三", 28, 168.7D);
        System.out.println();
        //正：右对齐，负：左对齐
        System.out.printf("姓名：%4s\n年龄：%-4d\n身高：%8.2f\n", "张三", 28, 168.7D);

        //String.format, System.out.printf 用法一致
        //java.util.Formatter
        String rs = String.format("姓名：%4s\n年龄：%-4d\n身高：%8.2f\n", "张三", 28, 168.7D);
        System.out.println(rs);
    }

    public static void code2() {
        //System  : java.lang.System
        //out     : Object   java.io.PrintStream
        //println : PrintStream类的成员方法，out对象的方法
        System.out.println();
//        System.out.printf();
        System.err.println();
        //System.in.read();
    }

    public static void main(String[] args) {


    }
}
