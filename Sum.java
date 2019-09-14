package com.tang;

/**
 * Author: Sweetie77
 * Created: 2019/9/12
 */
public class Sum {

// 两个整数相加

    public char[] addStrNums(String str1, String str2) {

        char[] num1 = str1.toCharArray(); // 将字符串1转化为字符数组1

        char[] num2 = str2.toCharArray(); // 将字符串2转化为字符数组2

        int nTakeOver = 0; // 进位符设置

        boolean flag = false; // 判断结果正负标识,负数设置为true，否则为false

        char num[] = null;

        int nsum = 0;

        // 一正数+一负数

        if ((num1[0] == '-' && num2[0] != '-')

                || (num1[0] != '-' && num2[0] == '-')) {

            if (num1[0] == '-' && num2[0] != '-') { // num1为负数字符串，num2为正数字符串

                num1 = numsAbs(num1);

                num2 = numsAbs(num2);

                if (getMaxAbs(num2, num1)) { // num2>num1,结果为正数

                    char temp[] = num1;

                    num1 = num2;

                    num2 = temp;

                    flag = false;

                } else { // 否则结果为负数

                    flag = true;

                }

            } else {

                num1 = numsAbs(num1);

                num2 = numsAbs(num2);

                if (getMaxAbs(num2, num1)) { // num2>num1,结果为负数

                    flag = true;

                    char temp[] = num1;

                    num1 = num2;

                    num2 = temp;

                } else { // 否则结果为正数

                    flag = false;

                }

            }

            num = new char[num1.length];

            for (int i = num1.length - 1, j = num2.length - 1; i >= 0; --i, --j) {

                if (j >= 0) {

                    nsum = num1[i] - num2[j] + nTakeOver;

                    if (nsum < 0) {

                        // 相减结果小于0 向上借一位

                        nTakeOver = -1;

                        nsum = nsum + 10;

                        num[i] = (char) (nsum + '0');

                    } else {

                        nTakeOver = 0;

                        num[i] = (char) (nsum + '0');

                    }

                } else {

                    nsum = num1[i] + nTakeOver - '0';

                    if (nsum < 0) {

                        nTakeOver = -1;

                        nsum = nsum + 10;

                        num[i] = (char) (nsum + '0');

                    } else {

                        nTakeOver = 0;

                        num[i] = (char) (nsum + '0');

                    }

                }

            }

        } else { // 两个正数相加或者两个负数相加

            if ((num1[0] == '-' && num2[0] == '-')) {

                num1 = numsAbs(num1);

                num2 = numsAbs(num2);

                flag = true; // 结果为负数

            }else{

                num1 = numsAbs(num1);

                num2 = numsAbs(num2);

                flag = false; //结果为正数

            }

            if (getMaxAbs(num2, num1)) { // 如果num1大于num2交换位置

                char temp[] = num1;

                num1 = num2;

                num2 = temp;

            }

            num = new char[num1.length];

            for (int i = num1.length - 1, j = num2.length - 1; i >= 0; --i, --j) {

                if (j >= 0) {

                    nsum = num1[i] - '0' + num2[j] - '0' + nTakeOver;

                    if (nsum >= 10) {

                        // 相加大于等于十 产生进位

                        nTakeOver = 1;

                        nsum = nsum - 10;

                        num[i] = (char) (nsum + '0');

                    } else {

                        nTakeOver = 0;

                        num[i] = (char) (nsum + '0');

                    }

                } else {

                    nsum = num1[i] - '0' + nTakeOver;

                    if (nsum >= 10) {

                        nTakeOver = 1;

                        nsum = nsum - 10;

                        num[i] = (char) (nsum + '0');

                    } else {

                        nTakeOver = 0;

                        num[i] = (char) (nsum + '0');

                    }

                }

            }

        }

        if(flag){ //结果为负数

            char []temp = new char[num.length + 1];

            temp[0] = '-';

            for (int i = 0; i < num.length; i++) {

                temp[i + 1] = num[i];

            }

            return temp;

        }else{

            return num;

        }

    }

// 取一个数字字符串数的绝对值

    public char[] numsAbs(char[] nums) {

        if (nums[0] != '-' && nums[0] != '+') { // 如果字符数组的第一位不是'-'直接返回

            return nums;

        }

        char temp[] = new char[nums.length - 1];

        for (int i = 0; i < temp.length; ++i) {

            temp[i] = nums[i + 1];

        }

        return temp;

    }


// 判断两个数子字符串的绝对值大小

    public boolean getMaxAbs(char num1[], char num2[]) {

        num1 = numsAbs(num1);

        num2 = numsAbs(num2);

        int len1 = num1.length;

        int len2 = num2.length;

        if (len1 > len2) { // 如果num1长度大于num2，则返回true

            return true;

        } else if (len1 < len2) { // 如果num1长度小于num2，则返回false

            return false;

        } else {

            for (int i = 0; i < len1; i++) { // 如果num1长度等于num2长度，则开始一个一个字符进行比较

                if (num1[i] > num2[i]) { // num1大，返回true

                    return true;

                } else if (num1[i] < num2[i]) { // num2大，返回false，否则继续下一位比较

                    return false;

                }

            }

        }

        return true;

    }


//打印两个整数相加的结果

    private void printNumber(char[] number) {

        boolean isBeginning0=true;

        boolean isJudge0 = true;

        //如果第一个字符为'-'则先打印出该字符 然后i从1开始遍历该字符数组否则从第一个非0字符开始打印该字符数组

        int i=0;

        if(number[0]=='-')

        {

            System.out.print(number[0]);

            ++i;

        }

        for(; i<number.length;i++){

            if(isBeginning0 && number[i]!='0'){

                break;

            }

        }

        for(; i<number.length;i++){

            System.out.print(number[i]);

        }

        for (int j = 0; j < number.length; j++) {

            if(number[j] != '0'){

                isJudge0 = false;

                break;

            }

        }

        if(isJudge0){

            System.out.println(0);

        }

        System.out.println();

    }

    public static void main(String[] args) {

        Sum m2 = new Sum();

        char[] nums = m2.addStrNums("+123", "-123");

        m2.printNumber(nums);



        char[] nums1 = m2.addStrNums("+123", "+123");

        m2.printNumber(nums1);



        char[] nums2 = m2.addStrNums("-123", "-123");

        m2.printNumber(nums2);



        char[] nums3 = m2.addStrNums("-123", "+123");

        m2.printNumber(nums3);

    }


}
