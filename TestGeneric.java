package com.bittech.generic;

/**
 * Author: secondriver
 * Created: 2018/12/9
 */
public class TestGeneric {
    
    //为什么会有泛型？
    public static void code1() {
        Point intPoint = new Point(10, 20);//10-> Integer -> Object
        //强制类型装换。向下转型。
        int intX = (int) intPoint.getX();
        int intY = (int) intPoint.getY();
        System.out.println("(" + intX + ", " + intY + ")");
        
        Point doublePoint = new Point(10.2D, 20.2D);
        double doubleX = (double) doublePoint.getX();
        double doubleY = (double) doublePoint.getY();
        System.out.println("(" + doubleX + ", " + doubleY + ")");
        
        Point stringPoint = new Point("东经80度", "北纬30度");
        String stringX = (String) stringPoint.getX();
        String stringY = (String) stringPoint.getY();
        System.out.println("(" + stringX + ", " + stringY + ")");
        
        Point point = new Point(20, "北纬30度");
//        int x = (int) point.getX();
//        String y = (String) point.getY();
//        int x = (int)point.getX();
//        int y = (int) point.getY(); //CCE
    }
    
    
    public static void main(String[] args) {
        
    
    }
}
