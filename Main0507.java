package Review;


import java.util.LinkedList;

/**
 * Author: Sweetie77
 * Created: 2019/5/7
 */
public class Main {
    public class Node {
        int val;
        Node left;
       Node right;

        Node(int x) {
            val = x;
        }
    }
    //求第k层结点的个数
    private static int getKLevelSize(Node root, int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }

    private static void insertSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            for (; j >= 0 && key < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }
}
