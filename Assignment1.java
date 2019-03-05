package com.bittech.Practice;

/**
 * Author: Sweetie77
 * Created: 2019/3/5
 */
class Tank {
    float level;
}

public class Assignment1 {
    public static void main(String[] args) {
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.level = 19;
        t2.level = 47;
        System.out.println("1: t1.level: " + t1.level + ",t2.level: " + t2.level);
        t1.level = t2.level;
        System.out.println("2: t1.level: " + t1.level + ",t2.level: " + t2.level);
        t1.level = 69;
        System.out.println("3: t1.level: " + t1.level + ",t2.level: " + t2.level);

    }

}
