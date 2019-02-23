package com.bittech.generic;

/**
 * Author: secondriver
 * Created: 2018/12/9
 */
public class Point2<T, S> {
    
    private T x;
    private S y;
    
    public Point2(T x, S y) {
        this.x = x;
        this.y = y;
    }
    
    public T getX() {
        return x;
    }
    
    public S getY() {
        return y;
    }
    
    
    @Override
    public String toString() {
        return "Point2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    
    public static void main(String[] args) {
        Point2<Integer, String> point2 = new Point2<>(20, "北纬30度");
        Integer x = point2.getX();
        String y = point2.getY();
        System.out.println("(" + x + ", " + y + ")");
    }
}
