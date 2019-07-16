package com.tang;

/**
 * Author: Sweetie77
 * Created: 2019/7/13
 */
public class RichAndPoor {
    public static void main(String[] args) {
        long sumRich = 0;
        long sumPoor = 0;
        for (int i = 1; i <= 30; i++) {
            sumRich += 10;
            sumPoor = sumPoor + (long) Math.pow(2, i - 1);
        }
        System.out.println(sumRich + "万元 " + sumPoor + "分");
    }
}
