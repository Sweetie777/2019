package com.bittech.tfdp;

/**
 * Author: Sweetie77
 * Created: 2019/2/16
 */
public class Test11 {

    public static void main(String[] args) {

        //子类对象 向上转型
        Person person = new Student();
        System.out.println(person.getPersonInfo());
        person.print();//子类对象

        //父类对象  向下转型

        //Student student =(Student) new Person(); //编译通过，运行CCE
        Student student = (Student) person; // student = person //编译不通过

        //对象  instanceof  类名
        System.out.println(person instanceof Student);
        System.out.println(student instanceof Student);


        Person person1 = new Student();
        if (person1 instanceof Student) {
            Student student1 = (Student) person1;
        } else {
            System.out.println("Person对象不能转换成Student对象");
        }


        //System.out.println(student.getPersonInfo());
        // System.out.println(student.getStudentInfo());

        //基本数据类型
        //int a =10;
        //byte b =(byte)a;
        //byte b = 10; //编译通过


    }

}

class Person {


    //成员方法
    public void print() {
        System.out.print("这是Person的print方法");
    }

    //父类方法
    private void hello() {
        System.out.println("这是Person的hello方法");

    }

    public String getPersonInfo() {
        return "person info";
    }
}

class Student extends Person {


    //复写了父类的print方法
    // public >  protected  > [default] > private
    public void print() {
        System.out.println("这是Student的print方法");
    }

    //子类方法
    //public void hello(){
    //super.hello();
    //  System.out.println("这是Student的hello方法");
    //}

    public String getStudentInfo() {
        return "Student info";
    }
}




