package com.bittech.Practice;

import java.util.Random;

/**
 * Author: Sweetie77
 * Created: 2019/3/5
 */
public class Bool {
    public static void main(String[] args) {
        Random random = new Random(47);
        int i = random.nextInt(100);
        int j = random.nextInt(100);
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("i<10 && j<10");
    }
}
