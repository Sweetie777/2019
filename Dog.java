package com.bittech.Practice;

/**
 * Author: Sweetie77
 * Created: 2019/3/5
 */
public class Dog {
    private String name;
    private String says;

    public Dog(String name, String says) {
        this.name = name;
        this.says = says;
    }

    public void said() {
        System.out.println("The dog " + name + " said:\"" + says + "\"");
    }

    static void compare(Dog d1, Dog d2) {
        System.out.println("==on top reference:" + (d1 == d2));
        System.out.println(".equals()on top reference:" + d1.equals(d2));
        System.out.println("==on name:" + (d1.name == d2.name));
        System.out.println(".equals()on name:" + d1.name.equals(d2.name));
        System.out.println("==on says:" + (d1.says == d2.says));
        System.out.println(".equals()on says:" + d1.says.equals(d2.says));
    }

    public static void main(String[] args) {
        Dog d1 = new Dog("spot", "Ruff!");
        Dog d2 = new Dog("scruffy", "Wurf!");
        d1.said();
        d2.said();
        Dog d3 = d1;
        System.out.println("compare d1 and d2");
        compare(d1, d2);
        System.out.println("compare d1 and d3");
        compare(d1, d3);
        System.out.println("compare d2 and d3");
        compare(d2, d3);

    }
}
