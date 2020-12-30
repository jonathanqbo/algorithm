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
public class Q117PopulatingNextRightPointersInEachNodeII {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node II.
     * Memory Usage: 39 MB, less than 24.56% of Java online submissions for Populating Next Right Pointers in Each Node II.
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null)
            return root;

        if (root.left == null && root.right == null)
            return root;

        Node levelHead = root;

        // Every level handle the connection for its next level
        while (levelHead != null) {
            Node node = levelHead;
            Node preNodeInNextLevel = null;
            levelHead = null;

            while (node != null) {
                if (node.left != null) {
                    if (preNodeInNextLevel != null) {
                        preNodeInNextLevel.next = node.left;
                    } else {
                        levelHead = node.left;
                    }

                    preNodeInNextLevel = node.left;
                }

                if (node.right != null) {
                    if (preNodeInNextLevel != null) {
                        preNodeInNextLevel.next = node.right;
                    } else {
                        levelHead = node.right;
                    }

                    preNodeInNextLevel = node.right;
                }

                node = node.next;
            }
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
