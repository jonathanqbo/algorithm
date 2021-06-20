package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:04 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q426ConvertBinarySearchTreetoSortedDoublyLinkedList {

    /**
     solution 1: Inorder recursion

     key:
     1. how to find the first node
     2. how to keep tracking the pre node for cur node

     ---------------

     solution 2: Inorder iterator (more straightforward)

     */
    class Solution {

        public TreeNode treeToDoublyList(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode head = new TreeNode();

            Deque<TreeNode> stack = new ArrayDeque<>();

            TreeNode node = root;
            TreeNode pre = head;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }

                node = stack.pop();

                pre.right = node;
                node.left = pre;

                pre = node;
                node = node.right;
            }

            //
            head.right.left = pre;
            pre.right = head.right;

            return head.right;
        }

    }

}
