package search;

/**
 * Author: Sweetie77
 * Created: 2019/4/8
 */
public class LeetCode {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //删除链表中所有的val
    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode result = null;
            ListNode last = null;

            ListNode cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                if (cur.val != val) {//如果当前值不是val, 就把当前值尾插到result链表上
                    //尾插
                    cur.next = null;
                    if (result == null) {
                        result = cur;
                    } else {
                        last.next = cur;
                    }//尾插结束

                    last = cur;//更新结果链表的最后一个结点
                }
                cur = next;
            }
            return result;
        }

        public ListNode removeElements2(ListNode head, int val) {
            ListNode result = null;
            ListNode cur = head;
            if (head == null) {
                return null;
            }
            if (cur.next != null) {
                cur = cur.next;
            } else {
                cur = cur.next.next;
            }
            if (head.val == val) {
                return head.next;
            } else {
                return head;
            }
        }

        public ListNode reverseList(ListNode head) {
            ListNode prev = null; //前指针结点
            ListNode cur = head; //当前指针结点
            //每次循环, 都将当前结点指向它前面的结点, 然后当前结点和前结点一起后移
            while (cur != null) {
                ListNode next = cur.next;//系一下. 暂存当前结点的下一结点, 用于后移
                cur.next = prev; //将当前结点指向它前面的结点
                prev = cur; //前结点后移
                cur = next; //当前结点后移
            }
            return prev;
        }

        public ListNode mergeTwoList(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            ListNode last = null;
            ListNode result = null;
            while(cur1 != null && cur2 != null){
                if(cur1.val <= cur2.val){
                    ListNode next = cur1.next;//保证循环
                    //尾插
                    cur1.next = null;
                    if(result == null){
                        result = cur1;
                    }else{
                        last.next= cur1;
                    }
                    last = cur1;//更新最后一个结点记录

                    cur1 = next;//保证循环
                }else{
                    ListNode next = cur2.next;//保证循环
                    //尾插
                    cur2.next = null;
                    if(result == null){
                        result = cur2;
                    }else{
                        last.next= cur2;
                    }
                    last = cur2;//更新最后一个结点记录

                    cur2 = next;//保证循环
                }
            }
            if(cur1 != null){
                last.next = cur1;
            }
            if(cur2 != null){
                last.next = cur2;
            }
            return  result;
        }


        public ListNode mergeTwoList2(ListNode l1, ListNode l2) {
            //类似归并排序中的合并过程
            ListNode dummyHead = new ListNode(0);
            ListNode cur = dummyHead;
            while(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    cur.next = l1;
                    cur = cur.next;
                    l1 = l1.next;
                }else{
                    cur.next = l2;
                    cur = cur.next;
                    l2 = l2.next;
                }
            }
            //任一为空,则直接连接另一条链表
            if(l1 == null){
                cur.next = l2;
            }
            if(l2 == null){
                cur.next = l1;
            }
            return dummyHead.next;
        }

        
            public static void main(String[] args) {
            ListNode n1 = new ListNode(1);
            ListNode n2 = new ListNode(2);
            ListNode n3 = new ListNode(3);
            ListNode n4 = new ListNode(4);
            ListNode n5 = new ListNode(5);
            ListNode n6 = new ListNode(6);

            n1.next = n2;
            n2.next = n3;
            n3.next = n4;
            n4.next = n5;
            n5.next = n6;
            n6.next = null;

            Solution solution = new Solution();
            ListNode result = solution.removeElements(n1, 6);
            ListNode cur = result;
            while (cur != null) {
                System.out.println(cur.val);
                cur = cur.next;
            }

        }


    }
}
