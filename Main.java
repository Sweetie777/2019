package com.bittech.test;

import java.util.Scanner;

/**
 * Author: Sweetie77
 * Created: 2019/2/20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, f, d, p;
        x = scanner.nextInt();
        f = scanner.nextInt();
        d = scanner.nextInt();
        p = scanner.nextInt();

        if(x*f >= d){
            System.out.println(d/x);
        }else{
            int m = ((d-(x*f))/(x+p))+f;
            System.out.println(m);
        }
    }
}
