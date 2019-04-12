package search;

/**
 * Author: Sweetie77
 * Created: 2019/4/12
 */
public class Interview {
    private static class ListNode {
        int val;
        ListNode next;
    }

    private static ListNode Reverse(ListNode head) {
        // 遍历原链表中的每一个结点
        // 把每一个结点，按头插的方式，放到一个新的链表中
        // 新链表一开始为空链表
        // 返回新的链表

        /**
         * 遍历链表的每一个结点，基本形式
         */
        /*
        for (ListNode node = head; node != null; node = node.next) {
        }

        ListNode node = head;
        while (node != null) {
            //node = node.next;
            ListNode next = node.next;
            // 先变更 node.next
            node.next = null;

            // 利用提前记录的 next 引用，找到下一个结点
            node = next;
        }
        */

        // 空的链表，没有一个结点的链表
        // 怎么表示一个链表，记录链表的第一个结点
        // 当链表中一个结点都没有时，记录的第一个结点引用就是 null

        ListNode node = head;
        // result 记录链表的第一个结点，从而代表整个链表
        // 当没有结点时，result 就是 null


        // 头插，把 node 头插到 result 代表的链表中
        /*
        node.next = result;
        result = node;
         */
        ListNode result = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = result;
            result = node;

            // 因为 node 的 next 被更改成新的值了
            // 所以直接等于是错的
            // 提前用变量记录
            // node = node.next;   // 这句基本是循环内部的最后一句
            node = next;
        }

        // 返回是逆置后的链表的第一个结点
        return result;
    }

    private static ListNode Reverse2(ListNode head) {
        ListNode result = null;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = result;
            result = node;
            node = next;
        }

        return result;
    }

    private static ListNode Merge(ListNode listA, ListNode listB) {
        if (listA == null) return listB;
        if (listB == null) return listA;
        // 原来的两个链表都是各自有序的
        // 合并完的链表需要整体有序
        // 同时遍历两个链表的各自结点
        // 进行值的比较，哪个值比较小，选哪个结点放入到新链表中
        // 放置的方式是尾插
        // 当一个链表中的结点被全部取走之后
        // 直接将剩余的另一个链表接到结果链表后就可以了

        /*
        把 node 尾插到 result 代表的链表
        node.next = null;
        if (result == null) {
            result = node;
        } else {
            ListNode last;  链表的最后一个结点
            last.next = node;
        }
         */
        ListNode result = null; // 记录结果链表的第一个结点，代表整个链表，可能是 null
        ListNode last = null;   // 记录结果链表的最后一个结点
        ListNode nA = listA;
        ListNode nB = listB;
        // 两个链表中仍然都有结点
        while (nA != null && nB != null) {
            if (nA.val <= nB.val) {
                if (result == null) {
                    result = nA;
                }else {
                    last.next = nA;
                }
                // last 发生变化
                last = nA;
                nA = nA.next;
            } else {
                if (result == null) {
                    result = nB;
                }else {
                    last.next = nB;
                }
                // last 发生变化
                last = nB;
                nB = nB.next;
            }
        }

        // 有一个链表的结点都取完了
        if (nA != null) {
            // nA 后边的结点还没有处理
            last.next = nA;
        } else {
            // nB 后边的结点还没有处理
            last.next = nB;
        }

        return result;
    }

    private int getLength(ListNode head) {
        int length = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            length++;
        }

        return length;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        ListNode longer = headA;
        ListNode shorter = headB;
        int diff = lenA - lenB;
        if (lenA < lenB) {
            diff = lenB - lenA;
            longer = headB;
            shorter = headA;
        }

        for (int i = 0; i < diff; i++) {
            longer = longer.next;
        }

        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer;
    }

    ListNode copy(ListNode head) {
        ListNode result = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode newNode = new ListNode(cur.val);
            // 把 newNode 尾插到 result 上
        }
    }

    class RNode {
        int val;
        RNode next;
        RNode random;   // 链表中任意结点的引用或者为 null

        RNode(int v) {
            this.val = v;
        }
    }

    void Test() {
        RNode n1 = new RNode(1);
        RNode n2 = new RNode(2);
        RNode n3 = new RNode(3);
        RNode n4 = new RNode(4);

        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = null;
        n1.random = n3;
        n2.random = n1;
        n3.random = n3;
        n4.random = null;
    }

    RNode CopyRList(RNode head) {
        RNode cur = head;
        RNode result = null;
        RNode last = null;
        while (cur != null) {
            RNode newNode = new RNode(cur.val);

            if (result == null) {
                result = newNode;
            }else {
                last.next = newNode;
            }
            last = newNode;

            cur = cur.next;
        }

        last.next = null;

        return result;
    }

    RNode copyRandomList(RNode head) {
        // 遍历原链表的每一个结点，创建新结点
        // 把新结点插入到原结点的后面
        RNode cur = head;
        while (cur != null) {
            RNode newNode = new RNode(cur.val);

            // 把 newNode 插入到 cur 后边
            newNode.next = cur.next;
            cur.next = newNode;

            // 让 cur 走向下一个原链表的结点
            cur = cur.next.next;
        }

        // 设置新结点的 random
        cur = head;
        while (cur != null) {
            RNode newNode = cur.next;
            if (cur.random == null) {
                newNode.random = null;
            } else {
                newNode.random = cur.random.next;
            }

            // cur 走到下一个老结点
            cur = cur.next.next;
        }

        // 拆
        cur = head;
        RNode result = head.next;
        while (cur != null) {
            RNode newNode = cur.next;
            cur.next = newNode.next;
            if (newNode.next != null) {
                newNode.next = newNode.next.next;
            }

            cur = cur.next;
        }

        return result;
    }
}












