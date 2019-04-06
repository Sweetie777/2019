package search;

/**
 * Author: Sweetie77
 * Created: 2019/4/6
 */

public class LinkedList {
    public class Node{
        public int value;
        public Node next;
        Node(int v){
            this.value = v;
            this.next = null;
        }
    }
    private Node head;
    void pushFront(Node node){
        node.next = this.head;
        this.head = node;
    }
    void pushBack(Node node){
        if(this.head ==null){
            this.head = node;
        }else{
            Node last = getLast();
            last.next = head;
        }
    }

    private Node getLast() {
        Node last = null;
        if(this.head == null){
            throw new Error();
            last = last.next;
        }
        return last;
    }

    public void display(){
        //通过循环遍历链表的每一个结点
    }
}
