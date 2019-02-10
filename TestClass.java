package com.bittech.tfdp;

/**
 * Author: Sweetie77
 * Created: 2019/2/10
 */

import java.util.Date;
public class TestClass {

    public static void main(String[] args) {
        //1.普通的一个对象，通过java.util.Date这个类实例化的
        Date date = new Date();
        //2.反向操作，反射
        Class classz = date.getClass();
        System.out.println(classz);

        //对象实例化
        //1.new 构造方法 2.反序列化 3.反射

        try {
            Date date1 = (Date) classz.newInstance();
            System.out.println(date1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //Class对象获取
        //1. object.getClass 2. ClassName.class 3. Class.forName("className");
        //建议：一般在开发反射的代码中我们经常使用类的全限定名
        Class<java.util.Date> dateClass = java.util.Date.class;
        System.out.println(dateClass);
        try {
            Date date2 = dateClass.newInstance();
            System.out.println(date2);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        Class dateClass1 = null;
        try {
            dateClass1 = Class.forName("java.util.Date");
            System.out.println(dateClass1);
        } catch (ClassNotFoundException e) {
            //注意：这里的异常
            e.printStackTrace();
        }

        //当前这三个Class对象都是有Class<java.util.Date>获取，都来描述
        //java.util.Date这个类
        System.out.println("比较三个Class对象");
        System.out.println(classz == dateClass);
        System.out.println(classz == dateClass1);

        //Class类是描述我们在Java中定义的类
        //Class类的对象是Class文件加载到JVM中的标识对象（类加载器）？

    }
}
