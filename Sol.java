package search;

/**
 * Author: Sweetie77
 * Created: 2019/4/6
 */
public class ListNode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            ListNode result = null;  //结果链表的第一个结点
            ListNode last = null;    //结果链表中的最后一个结点

            While(cur1 != null && cur2 != null){
                if(cur1.val <= cur2.val){
                    //1.
                    ListNode next = cur1.next;//保证循环继续

                    cur1.next = null;
                    if(result == null){
                        result = cur1;
                    }else{
                        last.result = cur1;
                    }
                    last = cur1;
                    cur1 = next;
                }else{
                    ListNode next = cur2.next;//保证循环继续

                    cur2.next = null;
                    if(result == null){
                        result = cur2;
                    }else{
                        last.result = cur2;
                    }
                    last = cur2;
                    cur2 = next;
                }
            }
            if(cur1 == null){
                cur.next = cur2;
            }else{
                cur.next = cur1;
            }
        }
    }
}
