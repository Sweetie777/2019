package com.sweetie77.IO.jcf;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Sweetie77
 * Created: 2018/12/11
 */
public class TestList {
    public static void main(String[] args) {
        //实例化一个ArrayList对象, list对象
        List<String> list1 = new ArrayList<>();
        list1.add("java");
        list1.add("c");
        list1.add("c++");
        list1.add("python");
        list1.add("php");
        list1.add("java");//list可以存放重复元素
        System.out.println(list1);

        list1.add(0,"go");
        System.out.println(list1);
        System.out.println(list1.size());
        System.out.println(list1.isEmpty());

        list1.addAll(list1);
        System.out.println(list1.remove("java"));

       
    }
}
