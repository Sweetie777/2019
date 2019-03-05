package com.bittech.Practice;

import java.util.Random;

/**
 * Author: Sweetie77
 * Created: 2019/3/5
 */
public class Coin {
    public static void main(String[] args) {
        //方法一: 随机取0,1
        Random random = new Random();
        int i = random.nextInt(2);
        System.out.println("i==" + i);
        if (i == 0) {
            System.out.println("反面");
        } else if (i == 1) {
            System.out.println("正面");
        }

        //方法二: 随机选取大于等于0.0且小于1.0的伪随机double值
        double b = Math.random();
        System.out.println("b==" + b);
        if (b < 0.5) {
            System.out.println("反面");
        } else {
            System.out.println("正面");
        }
    }
}
