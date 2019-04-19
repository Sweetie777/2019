package search;

/**
 * Author: Sweetie77
 * Created: 2019/4/19
 */
public class Node {
    public char value;
    public Node left;
    public Node right;

    Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

