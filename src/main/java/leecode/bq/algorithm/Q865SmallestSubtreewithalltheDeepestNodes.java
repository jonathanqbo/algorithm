package leecode.bq.algorithm;

import leecode.bq.TreeNode;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:28 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q865SmallestSubtreewithalltheDeepestNodes {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    /**

     solution: Recursion with keep tracking depth and LCN

     KEY: tracking depth and lowest common node

     @See 236. Lowest Common Ancestor of a Binary Tree

     */
    class Solution {

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            NodeStats result = dfs(root);
            return result.subtreeRoot;
        }

        public NodeStats dfs(TreeNode node) {
            NodeStats result = new NodeStats();

            if (node == null) {
                return result;
            }

            NodeStats left = dfs(node.left);
            NodeStats right = dfs(node.right);

            if (left.depth == right.depth) {
                result.depth = left.depth + 1;
                result.subtreeRoot = node;
            } else if (left.depth > right.depth) {
                result.depth = left.depth + 1;
                result.subtreeRoot = left.subtreeRoot;
            } else {
                result.depth = right.depth + 1;
                result.subtreeRoot = right.subtreeRoot;
            }

            return result;
        }

    }

    // KEY
    class NodeStats {
        int depth = 0;
        TreeNode subtreeRoot = null;
    }

}
