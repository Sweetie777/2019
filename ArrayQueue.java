package queue;

/**
 * Author: Sweetie77
 * Created: 2019/7/18
 */
public class ArrayQueue {
    public final Object[] items;
    public  int head = 0;
    public  int tail = 0;
    public ArrayQueue(int capacity){
        this.items = new Object[capacity];
    }

    public boolean put(Object item){
        if(head == (tail + 1)%items.length){
            return false;
        }
        items[tail] = item;
        tail = (tail + 1)%items.length;
        return true;
    }

    public Object peek(){
        if(head == tail){
            return null;
        }
        return items[head];
    }

    public Object poll(){
        if(head == tail){
            return null;
        }
        Object item = items[head];
        items[head] = null;
        head = (head +1) % items.length;
        return item;
    }


    public boolean isFull(){
        return head == (tail + 1) % items.length;
    }

    public int size(){
        if(tail >= head){
            return tail - head;
        }else{
            return tail + items.length - head;
        }
    }


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        System.out.println(queue.put("A"));
        System.out.println(queue.put("B"));
        System.out.println(queue.put("C"));
        System.out.println(queue.put("D"));
        System.out.println(queue.isFull());//true
        System.out.println(queue.size());//3
        System.out.println(queue.peek());//A
        System.out.println(queue.poll());//A
        System.out.println(queue.poll());//B
        System.out.println(queue.poll());//C
        System.out.println(queue.isFull());//false

    }
}
