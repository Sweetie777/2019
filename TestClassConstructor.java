package com.bittech.tfdp;

/**
 * Author: Sweetie77
 * Created: 2019/2/10
 */


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClassConstructor {

    //Constructor
    public static void code1() {
        try {
            Class clases = Class.forName("com.bittech.reflect.Person");

            //1.构造方法
            Constructor[] constructors = clases.getConstructors();
            System.out.println("打印输出Person类的构造方法：");
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }
            System.out.println("打印输出Person类的一个参数的构造方法：");
            System.out.println(clases.getConstructor(java.lang.String.class));

            //2. class.newInstance => 类里面有无参数构造方法
            //Person();
            System.out.println((Person) clases.newInstance());


            //Person(String name)
            //Constructor => 获取构造方法对象，执行构造对象的newInstance(参数值...)
            Constructor constructor = clases.getConstructor(java.lang.String.class);
            //constructor.newInstance
            Person person = (Person) constructor.newInstance("张三");
            System.out.println(person);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void code2() {
        try {
            Class clases = Class.forName("com.bittech.reflect.Person");

            //1.获取Person类中的所有普通方法
//            Method[] methods = clases.getMethods();
//            for (Method m : methods) {
//                System.out.println(m);
//            }

            //2.获取Person类中的setName方法
            Method setNameMethod = clases.getMethod("setName", java.lang.String.class);

            //3.调用方法
            Person person = (Person) clases.newInstance();
            Object voidObject = setNameMethod.invoke(person, "比特科技");
            System.out.println("setName=" + voidObject);
            System.out.println(person);
            Method getNameMethod = clases.getMethod("getName");
            Object stringObject = getNameMethod.invoke(person);
            System.out.println("getName=" + stringObject);
            System.out.println(person);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Class clases = Class.forName("com.bittech.reflect.Student");
            //获取属性 public
            System.out.println("输出Student类的所有公开属性：");
            for (Field f : clases.getFields()) {
                System.out.println(f);
            }

            System.out.println("输出Student类的本类声明的属性");
            for (Field f : clases.getDeclaredFields()) {
                System.out.println(f);
            }

            System.out.println("获取指定属性");
            Field major = clases.getDeclaredField("major");
            System.out.println(major);


            //Student一个对象
            Student student = (Student) clases.newInstance();
            System.out.println("实例化后的信息：" + student);
            major.setAccessible(true);
            major.set(student, "计算机科学与技术");
            System.out.println("通过major Field赋值之后：" + student);
            Object value = major.get(student);
            System.out.println("通过major Field获取值：" + value);

            //获取Field类型
            System.out.println(major.getType());

        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}

class Person {

    public String name;
    private Integer age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person {

    private String teacher;

    private String major;

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", major='" + major + '\'' +
                "} " + super.toString();
    }
}