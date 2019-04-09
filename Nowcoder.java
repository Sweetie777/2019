package search;

import java.util.List;

/**
 * Author: Sweetie77
 * Created: 2019/4/9
 */
public class Nowcoder {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static class Solution {
        public ListNode partition(ListNode pHead, int x) {
            ListNode small = null;
            ListNode smallLast = null;
            ListNode big = null;
            ListNode bigLast = null;

            ListNode cur = pHead;
            while(cur != null){
                ListNode next = cur.next;
                if(cur.val < x){
                    cur.next = null;
                    if(small == null){
                        small = cur;
                    }else{
                        smallLast = cur.next;
                    }
                    smallLast = cur;
                }else{
                    big.next = null;
                    if(big == null){
                        big = cur;
                    }else{
                        bigLast = cur.next;
                    }
                    bigLast = cur;
                }
                cur = next;
            }
            if(small == null){
                return big;
            }else{
                smallLast.next = big;
                return small;
            }
        }

        public static void main(String[] args) {


        }
    }
}
