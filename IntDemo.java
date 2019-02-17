package com.bittech.test;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Author: Sweetie77
 * Created: 2019/2/17
 */
public class IntDemo {
    private int num;

    public IntDemo(int num) {
        this.num = num;
    }

    public int intValue() {
        return this.num;
    }

    public static void main(String[] args) {
        //子类对象向上转型
        Object object = new IntDemo(55);
        IntDemo temp = (IntDemo) object;//向下转型
        System.out.println(temp.intValue());//取出里面的基本数据类型操作\


        Integer num = new Integer(55);//装箱
        int data = num.intValue();//拆箱
        System.out.println(data);

        //自动装箱
        Integer x = 55;
        //可以直接利用包装类对象操作
        System.out.println(++x * 5);//280

        Integer num1 = new Integer(10);
        Integer num2 = new Integer(10);
        System.out.println(num1 == num2);
        System.out.println(num1 == new Integer(10));
        System.out.println(num.equals(new Integer(10)));

        //将字符串变为int
        String str = "123";
        int num1 = Integer.parseInt(str);
        System.out.println(num1);

        //将字符串变为double
        String str1 = "123";//String类型
        double num2 = Double.parseDouble(str);
        System.out.println(num2);

        //观察非数字错误
        String str2 = "123aaa";//String类型
        double num3 = Double.parseDouble(str);
        System.out.println(num3);

        String str3 = "true";//String类型
        boolean num4 = Boolean.parseBoolean(str3);
        System.out.println(num4);
    }
}

