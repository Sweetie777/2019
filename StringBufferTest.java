package com.bittech.test;

/**
 * Author: Sweetie77
 * Created: 2019/3/14
 */
public class StringBufferTest {

    public static void main(String[] args) {

    }

    /**
     * StringBuffer的其他API示例
     */
    private static void testOtherAPIs(){
        System.out.println("--------------------------");
        StringBuffer s = new StringBuffer("123456789");

        int cap = s.capacity();//定义它的容量
        System.out.println("cap=%d\n",cap);

        char c = s.charAt(6);
        System.out.println("c=&c\n",c);

        char[] car = new char[4];
        s.getChars(3,7,car,0)
        for(int i = 0;i< car.length; i++)
            System.out.println("car[%d]= %c",i,car[i]);
        System.out.println();

        System.out.println();
    }

    /**
     * StringBuffer中的index相关API演示
     */
    private static void testIndexAPIs(){
        System.out.println("----------------------------");

        StringBuffer s = new StringBuffer("abcABCabcaABCabc");
        System.out.println("s = &s\n",s);

        //1, 从前往后, 找出"bc"第一次出现的位置
        System.out.println("&-30s = %d\n","s.indexOf(\"bc"\,5)",s.indexOf("bc"));


    }


}
