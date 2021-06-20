package leecode.bq.algorithm;

import leecode.bq.TreeNode;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 9:22 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q250CountUnivalueSubtrees {
    class Solution {
        int count = 0;

        public int countUnivalSubtrees(TreeNode root) {
            if (root == null)
                return 0;

            isUnivalSubtree(root);
            return count;
        }

        private boolean isUnivalSubtree(TreeNode node) {
            if (node.left == null && node.right == null) {
                count++;
                return true;
            }

            boolean isUnival = true;
            if (node.left != null) {
                isUnival = isUnivalSubtree(node.left) && (node.val == node.left.val);
            }

            if (node.right != null) {
                isUnival = isUnivalSubtree(node.right) && (node.val == node.right.val) && isUnival;
            }

            if (!isUnival)
                return false;

            count++;
            return true;
        }
    }
}
