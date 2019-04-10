package search;

import java.util.List;

/**
 * Author: Sweetie77
 * Created: 2019/4/9
 */
public class Nowcoder1 {

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

        public int length(ListNode head){
            int len = 0;
            ListNode cur= head;
            while(cur != null){
                len++;
                cur = cur.next;
            }
            return len;
        }

        public ListNode reverse(ListNode head){
            ListNode result = null;
            ListNode cur = head;
            while(cur != null){
                ListNode next = cur.next;
                cur.next = result;
                result = cur;
                cur = next;
            }
            return result;
        }

        public boolean chkPalindrome(ListNode A) {
            // write code here
            int len = length(A);
            int halfLen = len / 2;

            ListNode middle = A;
            for (int i = 0; i < halfLen; i++) {
                middle = middle.next;
            }

            ListNode r = reverse(middle);
            ListNode c1 = A;
            ListNode c2 = r;


            while (c1 != null && c2 != null) {
                if (c1.val != c2.val) {
                    return false;
                }

                c1 = c1.next;
                c2 = c2.next;
            }

            return true;
        }

        public static void main(String[] args) {

        }
    }
}
