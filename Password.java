package testdemo;

/**
 * Author: Sweetie77
 * Created: 2019/3/18
 */


import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.next();
            if(str.length()>8&&Con(str)>=3&&Ischongfu(str)){
                System.out.println("OK");
            }else {
                System.out.println("NG");
            }
        }
    }
    public static int Con(String str){
        int count=0;
        if(str.length()-str.replaceAll("[A-Z]","").length()>0){
            count++;
        }
        if(str.length()-str.replaceAll("[a-z]","").length()>0){
            count++;
        }
        if(str.length()-str.replaceAll("[0-9]","").length()>0){
            count++;
        }
        if(str.replaceAll("[0-9,A-Z,a-z]","").length()>0){
            count++;
        }
        return count;
    }
    public static boolean Ischongfu(String str){
        int [][] dp=new int[str.length()+1][str.length()+1];
        for(int i=0;i<str.length();i++){
            for(int j=0;j<str.length();j++) {
                if(str.charAt(i)==str.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                }
            }
        }
        int [] a=new int[str.length()];
        for(int i=0;i<=str.length();i++){
            for(int j=0;j<=str.length();j++) {
                if(str.charAt(i)!=str.charAt(j)) {
                    a[dp[i][j]]++;
                }
            }
        }
        for(int i=3;i<a.length;i++){
            if(a[i]>1){
                return false;
            }
        }
        return true;
    }
}