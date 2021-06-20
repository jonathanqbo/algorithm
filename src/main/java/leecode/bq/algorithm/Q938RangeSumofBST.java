package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:31 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q938RangeSumofBST {

    /**

     solution 1 (preferred): simple recursion by going to left/right/both by checking root.val with low, high

     solution 2: iterator version

     solution 3: follow inorder traversal (not good for this problem)
     */

    class Solution {

        public int rangeSumBST(TreeNode root, int low, int high) {
            // NOTE: LinkedList support NULL, ArrayDeque doesn't support NULL
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);

            int sum = 0;
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node == null) {
                    continue;
                }

                if (node.val >= low && node.val <= high) {
                    sum += node.val;
                    stack.push(node.left);
                    stack.push(node.right);
                } else if (node.val < low) {
                    stack.push(node.right);
                } else if (node.val > high) {
                    stack.push(node.left);
                }
            }

            return sum;
        }

    }

    class Solution2 {

        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) {
                return 0;
            }

            if (root.val >= low && root.val <= high) {
                return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
            }

            if (root.val > high) {
                return rangeSumBST(root.left, low, high);
            }

            if (root.val < low) {
                return rangeSumBST(root.right, low, high);
            }

            return 0;
        }

    }

}
