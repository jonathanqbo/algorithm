package leecode.bq.algorithm;

import leecode.bq.TreeNode;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 9:57 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q333LargestBSTSubtree {

    /**

     solution: recursion

     key: recursion(node) and return {min, max, node amount}

     key: how to handle leaf nodes, ie null left/right child, and know if cur subtree is bst by using using Integer.MAX_VALUE, Integer.MIN_VALUE

     */

    class Solution {

        public int largestBSTSubtree(TreeNode root) {
            BSTSubTreeStats result = helper(root);
            return result.amount;
        }

        private BSTSubTreeStats helper(TreeNode node) {
            if (node == null) {
                return new BSTSubTreeStats();
            }

            BSTSubTreeStats left = helper(node.left);
            BSTSubTreeStats right = helper(node.right);

            BSTSubTreeStats result = new BSTSubTreeStats();
            // KEY: by compare with left/right node min/max value, can know if it's a valid bst
            if (left.max < node.val && right.min > node.val) {
                result.min = left.min == Integer.MAX_VALUE ? node.val : left.min;
                result.max = right.max == Integer.MIN_VALUE ? node.val : right.max;
                result.amount = left.amount + right.amount + 1;
            } else {
                result.min = Integer.MIN_VALUE;
                result.max = Integer.MAX_VALUE;
                result.amount = Math.max(left.amount, right.amount);
            }

            return result;
        }

    }

    class BSTSubTreeStats {
        // KEY: default value is set to valid BST
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // NOTE: not necessary, can know it from node.val >< left.val, right.val
        // boolean isBST = true;
        int amount;
    }

}
