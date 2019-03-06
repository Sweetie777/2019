package com.bittech.Practice;

/**
 * Author: Sweetie77
 * Created: 2019/3/5
 */
class Letter {
    float c;
}

public class PassObject1 {
    static void f(Letter y) {
        y.c = 'z';

    }

    public static void main(String[] args) {
        Letter x = new Letter();
        x.c = 'a';
        System.out.println("1: x.c:" + x.c);
        f(x);
        System.out.println("2: x.c:" + x.c);
    }

}
