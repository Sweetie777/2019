package search;

import java.util.List;

/**
 * Author: Sweetie77
 * Created: 2019/4/13
 */
public class Tree {
    public class Node {
        int val;
        Node left;
        Node right;

        Node(int x) {
            val = x;
        }
    }

    /*
    求二叉树高度
     */
    private static int height(Node root){
        if(root == null){
            return 0;
        }else{
            int left = height(root.left);
            int right = height(root.right);
            return (left > right ? left : right) +1;
        }
    }
    private static int kLevel(Node root, int k ){
        if(root == null){
            return 0;
        }else if(k == 1){
            return 1;
        }else{
            return kLevel(root.left,k-1)+ kLevel(root.right,k-1);
        }
    }

    //找到包含v的结点, 返回结点引用
    //如果没找到, 返回null
    //
    private Node find(Node root,char v){
        if(root == null){
            return null;
        }
        if(root.val == v){
            return root;
        }
        Node r = find(root.left,v);
        if(r != null){
            return r;
        }
        r = find(root.right,v);
        if(r != null){
            return r;
        }
        return null;
    }

    private boolean isMirror(Node p,Node q){
        if(p == null && q == null){
            return true;
        }
        if(p != null && q != null && q.val == p.val){
            return isMirror(q.left,p.right) && isMirror(q.right,p.left);
        }else{
            return false;
        }
    }

}
