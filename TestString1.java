package com.bittech.test;

/**
 * Author: Sweetie77
 * Created: 2019/2/18
 */
public class TestString1 {
    public static void main(String[] args) {
        System.out.println(fistUpper("compute"));
        System.out.println(fistUpper(""));
        System.out.println(fistUpper("a"));





        String string = "hello world";
        System.out.println("["+string+"]");
        System.out.println("["+string.trim()+"]");

        String string1 = "hello&&**#$%world哈哈哈";
        System.out.println(string1.toUpperCase());
        System.out.println(string1.toLowerCase());
        System.out.println(string1.length());

        System.out.println("hello".isEmpty());
        System.out.println("".isEmpty());
        System.out.println(new String().isEmpty());

    }

    public static String fistUpper(String str){
        if("".equals(str)||str==null){
            return str;
        }
        if(str.length()>1){
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }
        return str.toUpperCase();
    }
}
