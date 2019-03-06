package com.bittech.Practice;

/**
 * Author: Sweetie77
 * Created: 2019/3/5
 */
class Letter1{
    char c;
}
public class PassObject {
    static void f(Letter1 y){
        y.c = 'z';

    }

    public static void main(String[] args) {
        Letter1 x = new Letter1();
        x.c = 'a';
        System.out.println("1: x.c:"+x.c);
        f(x);
        System.out.println("2: x.c:"+x.c);
    }

}
