package search;

import java.util.Stack;

/**
 * Author: Sweetie77
 * Created: 2019/4/20
 */
public class NoR {
    public class Node {
        char value;
        Node left;
        Node right;

        Node(char x) {
            this.value = x;
        }
    }

    private static void preorderNoR(Node root) {
        Node cur = root;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                System.out.println(cur.value);
                stack.push(cur.left);
                cur = cur.left;
            }
            Node top = stack.pop();
            cur = top.right;

        }
    }

    private static void inorderNoR(Node root) {
        Node cur = root;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.pop();
            System.out.println(top.value);
            cur = top.right;
        }
    }

    private static void posterNoR(Node root) {
        Node cur = root;
        Node last = null; //上一次被完整遍历过的树的根结点
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.peek();

            if (top.right == null) {
                System.out.println(top.value);
                stack.pop();
                last = top;
            } else if (top.right == last) {
                System.out.println(top.value);
                stack.pop();
                last = top;
            } else {
                cur = top.right;
            }
        }


    }
}
