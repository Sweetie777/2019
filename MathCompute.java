package com.bittech.tfdp;

/**
 * Author: Sweetie77
 * Created: 2019/2/16
 */
public class MathCompute {

    //方法定义
    public static int add(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static int add(int a, int b, int c) {
        int sum = a + b + c;
        return sum;
    }

    public static double add(double a, double b) {
        double sum = a + b;
        return sum;
    }

    public static void div(int a, int b) {
        if (b == 0) {
            return;
        }
        int div = a / b;
        System.out.println(div);
    }

    public static void print() {
        System.out.println("hello");
        print();
    }

    // 100 + 99
    // 100 + 99 + 98
    // 100 + 99 + 98  + .... + 1
    public static int compute(int i) {
        if (i == 1) {
            return 1;
        } else {
            return i + compute(i - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(compute(100));
    }
}