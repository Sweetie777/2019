package com.bittech.Practice;

/**
 * Author: Sweetie77
 * Created: 2019/3/5
 */

class Tank1 {
    int level;
}

public class Assignment {
    public static void main(String[] args) {
        Tank1 t1 = new Tank1();
        Tank1 t2 = new Tank1();
        t1.level = 9;
        t2.level = 47;
        System.out.println("1: t1.level: " + t1.level + ",t2.level: " + t2.level);
        t1.level = t2.level;
        System.out.println("2: t1.level: " + t1.level + ",t2.level: " + t2.level);
        t1.level=27;
        System.out.println("3: t1.level: " + t1.level + ",t2.level: " + t2.level);

    }

}
