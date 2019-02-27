package com.bittech.test;

/**
 * Author: Sweetie77
 * Created: 2019/2/27
 **/

import static com.bittech.test.MyMath.mul;


public class TestFeature {
       /*
        Java语言开发桌面版程序：
        java.awt
        javax.swing 目前太流行了

        客户端程序
        Java FX （JavaSE + FX API + XML + CSS + HTML4/5 + JavaScript）
        Android （JavaSE + Google Android API）
       */


    public static int add(int[] data) {
        if (data == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;

        /*


        System.out.println(add(new int[]{1}));
        System.out.println(add(new int[]{}));
        System.out.println(add(null));
        System.out.println(add(new int[]{1, 2}));
        System.out.println(add(new int[]{1, 2, 3, 4, 5}));

         */
    }

    public static int add1(int... data) {
        //int ... data  => int[]
        if (data == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum;
        /*

        System.out.println(add1());
        System.out.println(add1(1));
        System.out.println(add1(1, 2));
        System.out.println(add1(1, 2, 3, 4, 5));
        System.out.println(add1(null));

         */
    }


    public static void print(String message, String... args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(message);
        for (int i = 0; i < args.length; i++) {
            stringBuilder.append(args[i]);
        }
        System.out.println(stringBuilder.toString());
        /*

           print("hello");
        print("hello", " world ");
        print("hello", " world ", " !!!");
        String st1 = "Hello";
        String str2 = "world";
        String str3 = "!!!";
        System.out.println(st1 + " " + str2 + " " + str3);

        print(str2, " ", str2, " ", str3);
         */
    }


    /*  //此两个方法一样的，不是重载方法
    public static void hello(String[] args){

    }

    public static void hello(String...args){

    }
    */


    public static void foreach() {
        int[] intArray = new int[]{1, 2, 3, 4, 5};
//        for (int i = 0, len = intArray.length; i < len; i++) {
//            System.out.println(intArray[i]);
//        }
        for (int anIntArray : intArray) {
            //每次循环（intArray）的时候会将数组中的元素赋值给变量（anIntArray）
            System.out.println(anIntArray);
        }
    }

    public static void code3() {
        //Java 支持静态导入 , 但是比建议使用，如果方法重名有可能存在二义性
//        System.out.println(add(1, 2));
        System.out.println(mul(1, 3));

        // 如果代码中同时使用到 两个 类名相同，包名不同 => 全限定名不同 使用类的全限定名 。 比如：java.lang.String com.bittech.String
    }

    public static void main(String[] args) {


    }

}
