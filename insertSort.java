package Sort;

import java.util.Arrays;

/**
 * Author: Sweetie77
 * Created: 2019/4/29
 */
public class insertSort {
    /**
    private static void swap(int[] array, int i , int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }*/
    //假设是有序的,
    public static void insertSort(int[] array){
        int temp;
        //外层循环需要控制排序的趟数(从1开始因为将第0位看成了有序的数据
        for(int i  = 1; i < array.length;i++){
            temp = array[i];
            //如果前一位(已排好的数据)比当前数据大, 那么就进入到循环比较
            while(i >= 1 && array[i -1] >temp){
                //往后退一个位置, 让当前数据与之前前位进行比较
                array[i] = array[i -1];
                //不断往前, 直到退出循环
                i--;
            }
            //退出循环说明找到了合适的位置, 将当前的数据插入到合适的位置中
            array[i] = temp;
        }
    }
    public static void insertSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            for (; j >= 0 && key < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }


    public static void main(String[] args) {
        int[] array = {9,3,1,5,2,4,3,8,7,6};
        insertSort(array);  //insertSort2(array);
        System.out.println(Arrays.toString(array));
    }


}
