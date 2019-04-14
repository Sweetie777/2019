package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: Sweetie77
 * Created: 2019/4/14
 */
public class BinaryTree2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                if (root.right != null) {
                    stack.push(root.right);
                }
                list.add(root.val);
                root = root.left;
            } else {
                root = stack.pop();
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null) stack.push(node.left);//和传统先序遍历不一样，先将左结点入栈
            if(node.right != null) stack.push(node.right);//后将右结点入栈
            list.add(0,node.val);                        //逆序添加结点值
        }
        return list;
    }
    public static void main(String[] args) {

    }
}
