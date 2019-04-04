package search;

public class MyLinkedList {
    /**
     * 链表中的一个结点
     */
    public class Node {
        public int value;   // 保存的是有效数据
        public Node next;   // 下一个结点的线索（引用）

        Node(int v) {
            this.value = v;
            this.next = null;
        }
    }

    // 如果一个结点都没有， head == null
    private Node head;      // 保存链表中第一个结点的引用

    MyLinkedList() {
        this.head = null;
    }

    // O(1)
    public void pushFront(int item) {
        Node node = new Node(item);
        node.next = this.head;
        this.head = node;
    }

    // O(1)
    public void popFront() {
        if (this.head == null) {
            throw new Error();
        }

        this.head = this.head.next;
    }

    // O(n)
    private Node getLast() {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }

        return cur;
    }

    // O(n)
    public void pushBack(int item) {
        Node node = new Node(item);
        if (this.head == null) {
            this.head = node;
        } else {
            Node last = getLast();
            last.next = node;
        }
    }

    // O(n)
    private Node getLastLast() {
        Node cur = this.head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    // O(n)
    public void popBack() {
        if (this.head == null) {
            throw new Error();
        }

        if (this.head.next == null) {
            this.head = null;
        } else {
            Node lastLast = getLastLast();
            lastLast.next = null;
        }
    }
}
