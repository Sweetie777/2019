package stack;

import java.util.Arrays;

/**
 * Author: Sweetie77
 * Created: 2019/7/17
 */
public class Stack {
    private int size;
    private int[]array;
    public Stack(){
        this(10);
    }
    public Stack(int init){
        if(init <= 0){
            init = 10;
        }
        array = new int[init];
    }

    /**
     * 入栈
     */
    public void push(int item){
        if(size == array.length){
            array = Arrays.copyOf(array,size*2);
        }
        array[size++] = item;
    }
    /**
     * 获取栈顶元素, 但是没有出栈
     */
    public int peek(){
        if(size == 0){
            throw new IndexOutOfBoundsException("栈是空的");
        }
        return array[size - 1];
    }
    /**
     * 出栈, 同时获取栈顶元素
     */
    public int pop(){
        int item = peek();
        size--;
        return item;
    }
    /**
     * 栈是否满了
     */
    public boolean isFull(){
        return size == array.length;
    }
    /**
     * 栈是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(1);
        stack.push(1);
        stack.push(2);
        System.out.println(stack.size());//2
        stack.push(3);
        System.out.println(stack.size());//3
        System.out.println(stack.peek());//3
        System.out.println(stack.size());//3
        System.out.println(stack.pop());//栈顶元素出栈, 返回3
        System.out.println(stack.pop());//栈顶元素出栈, 返回2
        System.out.println(stack.size());//1
    }
}
