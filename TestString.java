package com.bittech.test;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Author: Sweetie77
 * Created: 2019/2/18
 */
public class TestString {

    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "hello";
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println("**************************");
        //compareTo()比较

        ////A->65 a->97
        System.out.println("A".compareTo("a"));//-32
        System.out.println("a".compareTo("A"));//32
        System.out.println("A".compareTo("A"));//0
        System.out.println("AB".compareTo("AC"));//-1

        String string = "helloworld";
        System.out.println(string.contains("world"));//true

        String str3 = "helloworld";
        System.out.println(str3.indexOf("world"));//5
        System.out.println(str3.indexOf("compute"));//-1, 没有找到
        if(str3.indexOf("hello")!= -1){
            System.out.println("可以找到指定字符串!");
        }


        String str4 = "helloworld";
        System.out.println(str4.indexOf("1"));//2
        System.out.println(str4.indexOf("1",5));//8
        System.out.println(str4.lastIndexOf("1"));//8

        String str5 = "**@@helloworld!!";
        System.out.println(str5.startsWith("**"));//true
        System.out.println(str5.startsWith("@@",2));//true
        System.out.println(str5.endsWith("!!"));//true

        //字符串的替换
        String str6 = "helloworld_";
        System.out.println(str6.replaceAll("1","_"));
        System.out.println(str6.replaceFirst("1",""));

        String str7 = "hello world hello compute";
        String[] result = str7.split(" ");//按照空格拆分
        for(String s:result){
            System.out.println(s);
        }

        String str8 = "hello world hello compute";
        String[] result1 = str8.split(" ",2);//按照空格拆分
        for(String s:result1){
            System.out.println(s);
        }


        String str9 = "compute:123|c:12";
        String[]result2 = str9.split("\\|");
        for(int i = 0; i<result.length;i++){
            String[]temp = result2[i].split(":");
            System.out.println(temp[0]+"="+temp[1]);
        }

        String str11 = "helloworld";
        System.out.println(str11.substring(5));
        System.out.println(str11.substring(0,5));
    }
}
