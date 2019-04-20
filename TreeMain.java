package search;


import java.util.LinkedList;
import java.util.List;

/**
 * Author: Sweetie77
 * Created: 2019/4/20
 */
public class TreeMain {

    public class TreeNode {
      char val;
        Node left;
        Node right;
        Node(char x) { this.val = x; }
  }
    private static void levelOrderTraversal(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);

        while (!queue.isEmpty()) {
            Node front = queue.pollFirst();
            System.out.println(front.value);

            if(front.left == null){
                queue.addLast(front.left);
            }
            if(front.right == null){
                queue.addLast(front.right);
            }
        }
    }

    private static List<List<Character>> levelOrder(Node root) {
        List<List<Character>> list = new List<>();
    }
}
