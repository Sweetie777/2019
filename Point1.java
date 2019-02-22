package com.bittech.test;

/**
 * Author: Sweetie77
 * Created: 2019/2/22
 */

public class Point1<T> {

    //x y 数据类型一致
    private T x;
    private T y;

    public Point1(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }


    public static void main(String[] args) {
        //Point Integer
        // Point1<Integer> point1 = new Point1<Integer>(10, 20); //JDK1.6-
        Point1<Integer> point1 = new Point1<>(10, 20);//JDK1.7+
        Integer x = point1.getX();
        Integer y = point1.getY();
        System.out.println("(" + x + ", " + y + ")");

        Point1<String> point2 = new Point1<>("东经20度", "北纬30度");
        String strX = point2.getX();
        String strY = point2.getY();
        System.out.println("(" + strX + ", " + strY + ")");

    }
}

