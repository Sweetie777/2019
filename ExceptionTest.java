package base;

import java.sql.SQLOutput;

/**
 * Author: Sweetie77
 * Created: 2019/7/16
 */
public class ExceptionTest {
    private int age;
    public static void main(String[]args){
//        System.out.println(test());
//        System.out.println(test1());
        System.out.println(test2().age);
    }

    public static ExceptionTest test2(){
        ExceptionTest exceptionTest = new ExceptionTest();
        try{
            exceptionTest.age = 1;
            System.out.println("try age= "+exceptionTest.age);
            return exceptionTest;
        }catch (Exception e){
            exceptionTest.age = 2;
            return exceptionTest;
        }finally {
//            exceptionTest = new ExceptionTest();
            exceptionTest.age = 3;
            System.out.println("finally age= "+exceptionTest.age);
        }
    }


//    public static int test1(){
//        int i = 0;
//        try{
//            i = 1;
//            System.out.println("try i= "+i);
//            return i;
//        }catch (Exception e){
//            i = 2;
//            return i;
//        }finally {
//            i = 3;
//            System.out.println("finally i= "+i);
//        }
//    }
//
//
//    public static int test(){
//        int i = 0;
//        try{
//            i = 1;
//            System.out.println("try i= "+i);
//            return i;
//        }catch (Exception e){
//            i = 2;
//            return i;
//        }finally {
//            i = 3;
//            System.out.println("finally i= "+i);
//            return i;
//        }
//    }



}
