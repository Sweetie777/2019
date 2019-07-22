package stack;

/**
 * Author: Sweetie77
 * Created: 2019/7/17
 */
public class Stack2Queue {
    private Stack stack1;
    private Stack stack2;
    private int maxLength;
    public Stack2Queue(int capacity){
        maxLength = capacity;
        stack1 = new Stack(capacity);
        stack2 = new Stack(capacity);

    }
    public boolean put(int item){
        if(stack1.isFull()||maxLength == size()){
            return false;//满了
        }
        stack1.push(item);
        return true;
    }
    public int poll(){
        if(stack2.isFull()){
            return stack2.pop();
        }else{
            while(stack1.isFull()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    private int size() {
        return stack1.size()+stack2.size();
    }

    public static void main(String[] args) {
        Stack2Queue queue = new Stack2Queue(5);
        queue.put(1);
        queue.put(2);
        System.out.println(queue.poll());//1
        queue.put(3);
        queue.put(4);
        System.out.println(queue.poll());//2
        System.out.println(queue.poll());//3 本次会把3,4两个元素从stack1倒入stack2


    }
}
