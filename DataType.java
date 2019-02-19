package com.bittech.test;

/**
 * Author: Sweetie77
 * Created: 2019/2/19
 */

public class DataType {
    //类型的默认值，需要跟类一起使用，作为类的成员变量或者静态值

    //private static int a;
    //private int a;

    public static void main(String[] args) {
        // byte b = (byte)300;
        //System.out.println(b); //44
        double d = 12.1;
        System.out.println(d * 2);
        //long  a  = 10L  // 凡是跟字母的用大写
        float f = 10.2F;
        System.out.println(f);
        System.out.println(1.1 * 1.1);

        int numA = 10;
        int numB = 4;
        System.out.println(numA / numB);//2
        System.out.println(numA / (double) numB);//2.5

        //char
        char ch = 'A'; //65
        int num = ch;
        num = num + 32;
        ch = (char) num;
        System.out.println(ch);

        char nine = '9';
        int intNine = 9;
        if ('9' == 9) {
            //true
            System.out.println("相等");
        } else {
            //false
        }

        //bool  true false
        //true false //保留字
        System.out.println(10 == 10);
        System.out.println(11 == 10);

        //java.lang.String
        String strName = "Java is best!";
        System.out.println(strName);//留个悬念
        String strMark = " Coding ";
        //String + 表示字符串拼接
        System.out.println(strName + strMark);
        //Person person = new Person();
        //System.out.println("This is num "+ person);//引用类型 toString();

        int num1 = 10;
        double num2 = 12.1;
        String result = "运算结果是:" + (num1 + num2);
        System.out.println(result);

        //\t 制表符空格 \n 换行 \" 转义
        System.out.print("\ta\n");
        System.out.print("\tb\n");
        System.out.print("\tc\n");
        System.out.print("\"Java6 666\"");

        //(a & z) + (b * c) - (d % f) = e; //按照运算符的优先级进行运算

    }
}




