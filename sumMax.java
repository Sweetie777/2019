package com.tang;

import java.util.*;

/**
 * Author: Sweetie77
 * Created: 2019/9/12
 */
public class sumMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        statisticSubStr(input);
    }

    public static void statisticSubStr(String s){
        String[]split = s.toLowerCase().split("");
        HashSet<String> hashSet = new HashSet<String>(Arrays.asList(split));
        TreeMap<String,Integer> hashMap = new TreeMap<>();
        for(String s1 :hashSet){

            int num = 0;
            for(int i = 0;i<split.length;i++){
                if(s1.toLowerCase().equals(split[i])){
                    num++;
                }
            }
            hashMap.put(s1.toLowerCase(),num);
        }
        Set<Map.Entry<String,Integer>>entries = hashMap.entrySet();
        for(Map.Entry<String,Integer> entry:entries){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
