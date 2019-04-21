package search;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: Sweetie77
 * Created: 2019/4/21
 */
public class TreeInterview {


    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    private static Pair<Node, Integer> createTree(char[] preOrder) {
        if (preOrder.length == 0) {
            return new Pair<>(null, 0);
        }

        if (preOrder[0] == '#') {
            return new Pair<>(null, 1);
        }

        Node root = new Node(preOrder[0]);
        Pair<Node, Integer> left = createTree(
                Arrays.copyOfRange(preOrder, 1, preOrder.length)
        );
        Pair<Node, Integer> right = createTree(
                Arrays.copyOfRange(preOrder, 1 + left.getValue(), preOrder.length)
        );

        root.left = left.getKey();
        root.right = right.getKey();

        return new Pair<>(
                root,
                1 + left.getValue() + right.getValue()
        );
    }

    private static void preOrderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.value);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    private static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.value);
            inOrderTraversal(root.right);
        }
    }

    private static void preOrderTree2Str(Node root, StringBuilder sb) {
        if (root != null) {
            sb.append('(');
            sb.append(root.value);
            if (root.left == null && root.right != null) {
                sb.append("()");
            } else {
                preOrderTree2Str(root.left, sb);
            }
            preOrderTree2Str(root.right, sb);
            sb.append(')');
        }
    }

    private static String tree2str(Node root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preOrderTree2Str(root, sb);
        sb.delete(0, 1);
        sb.delete(sb.length() - 1, sb.length());

        return sb.toString();
    }

    private static boolean find(Node root, Node t) {
        if (root == null) {
            return false;
        }

        if (root == t) {
            return true;
        }

        if (find(root.left, t)) {
            return true;
        }

        return find(root.right, t);
    }

    private static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == p || root == q) {
            return root;
        }

        boolean pInLeft = find(root.left, p);
        boolean qInLeft = find(root.left, q);

        if (pInLeft && qInLeft) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (!pInLeft && !qInLeft) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    private static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        // 启动
        queue.addLast(root);

        // 拉下线整个过程
        while (!queue.isEmpty()) {
            Node front = queue.pollFirst();
            System.out.print(front.value);

            // 拉下线，有要求，空的不要
            if (front.left != null) {
                queue.addLast(front.left);
            }
            if (front.right != null) {
                queue.addLast(front.right);
            }
        }
    }

    private static List<List<Character>> levelOrder2(Node root) {
        List<List<Character>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        class NodeLevel {
            Node node;
            int level;

            public NodeLevel(Node node, int level) {
                this.node = node;
                this.level = level;
            }
        }

        LinkedList<NodeLevel> queue = new LinkedList<>();
        queue.addLast(new NodeLevel(root, 0));

        while (!queue.isEmpty()) {
            NodeLevel front = queue.pollFirst();
            Node node = front.node;
            int level = front.level;
            // 处理返回值
            if (list.size() == level) {
                list.add(new ArrayList<>());
            }
            list.get(level).add(node.value);

            if (node.left != null) {
                queue.addLast(new NodeLevel(node.left, level + 1));
            }
            if (node.right != null) {
                queue.addLast(new NodeLevel(node.right, level + 1));
            }
        }

        return list;
    }


    private static boolean isComplete(Node root) {
        if (root == null) {
            return true;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);

        while (true) {
            Node front = queue.pollFirst();
            if (front == null) {
                // 遇到空了，下一步去判断队列中剩余的结点，是否是全是空
                break;
            }

            queue.addLast(front.left);
            queue.addLast(front.right);
        }

        // 判断时候所有的结点都是非空
        while (!queue.isEmpty()) {
            Node front = queue.pollFirst();
            if (front != null) {
                return false;
            }
        }

        return true;
    }

    private static Node prev = null;
    private static Node head = null;

    private static void buildDList(Node node) {
        node.left = prev;   // node.prev = prev
        if (prev != null) {
            prev.right = node;  // prev.next = node;
        } else {
            head = node;
        }

        prev = node;
    }

    private static void inOrderTraversalSearchTree(Node root) {
        if (root != null) {
            inOrderTraversalSearchTree(root.left);
            buildDList(root);
            inOrderTraversalSearchTree(root.right);
        }
    }

    private static Node searchTreeToSortedList(Node root) {
        prev = null;
        head = null;

        inOrderTraversalSearchTree(root);

        return head;
    }

    private static Node buildSearchTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        e.left = b;
        e.right = g;
        b.left = a;
        b.right = d;
        d.left = c;
        g.left = f;
        g.right = h;

        return e;
    }

    public static void main(String[] args) {
        char[] preOrder = new char[]{
                'A', 'B', 'D', '#', '#', 'E', '#', '#', 'C', 'F'
        };

        Pair<Node, Integer> pair = createTree(preOrder);
        Node root = pair.getKey();
        preOrderTraversal(root);
        System.out.println();
        inOrderTraversal(root);
        System.out.println();

        String str = tree2str(root);
        System.out.println(str);

        levelOrderTraversal(root);
        System.out.println();

        List<List<Character>> list = levelOrder2(root);
        System.out.println("{");
        for (List<Character> innerList : list) {
            System.out.print("{ ");
            for (char value : innerList) {
                System.out.print(value + " ");
            }
            System.out.println("}");
        }
        System.out.println("}");

        if (isComplete(root)) {
            System.out.println("是完全二叉树");
        } else {
            System.out.println("不是完全二叉树");
        }

        Node searchTreeRoot = buildSearchTree();
        Node head = searchTreeToSortedList(searchTreeRoot);

        for (Node cur = head; cur != null; cur = cur.right) {
            System.out.println(cur.value);
        }
    }
}
