package leecode.bq.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/27/20 10:02 PM
 */
public class Q116PopulatingNextRightPointersInEachNode {

    /**
     * solution 1: BFS
     *
     * Runtime: 2 ms, faster than 40.87% of Java online submissions for Populating Next Right Pointers in Each Node.
     * Memory Usage: 39.4 MB, less than 32.09% of Java online submissions for Populating Next Right Pointers in Each Node.
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null)
            return root;

        Queue<Node> q = new LinkedList();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i <  size; i++) {
                Node node = q.poll();
                if (node.right != null) {
                    q.offer(node.left);
                    q.offer(node.right);
                }

                // the most right node don't have next
                if (i < size - 1) {
                    node.next = q.peek();
                }
            }
        }

        return root;
    }

    /**
     * solution 2:
     * create "next" connection for each layer from top to bottom,
     * then create connection for n + 1 layer by using n layer connection from left to right.
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node.
     * Memory Usage: 39 MB, less than 82.74% of Java online submissions for Populating Next Right Pointers in Each Node.
     *
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null)
            return root;

        Node levelHead = root;

        // Every level handle the connection for its next level
        while (levelHead.left != null) {
            Node node = levelHead;

            while (node != null) {
                node.left.next = node.right;
                if (node.next != null) {
                    node.right.next = node.next.left;
                }

                node = node.next;
            }

            levelHead = levelHead.left;
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}
