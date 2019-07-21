package queue;

/**
 * Author: Sweetie77
 * Created: 2019/7/18
 */
public class Queue2Stack {
    private ArrayQueue queue1;
    private ArrayQueue queue2;
    private int maxLength;
    public Queue2Stack(int capacity){
        maxLength = capacity;
        queue1 = new ArrayQueue(capacity);
        queue1 = new ArrayQueue(capacity);
    }

    /**
     * 入栈
     */
    public boolean push(int item){
        if(size() == maxLength){
            return  false;
        }
        if(!queue2.isFull()){
            queue1.put(item);
        }else{
            queue2.put(item);
        }
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public Object pop(){
        if(size() == 0){
            throw new IndexOutOfBoundsException("栈空了");
        }else{
            if(!queue2.isFull()){
                while(queue1.size() > 1){
                    queue2.put(queue1.poll());
                }
                return queue1.poll();
            }else{
                while(queue2.size() > 1){
                    queue1.put(queue2.poll());
                }
                return queue2.poll();
            }
        }
    }
    public int size(){
        return queue1.size()+queue2.size();
    }

    public static void main(String[] args) {
        Queue2Stack stack =  new Queue2Stack(5);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
