package leecode.bq.algorithm;

import leecode.bq.TreeNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/26/20 8:46 PM
 */
public class Q112PathSum {

    /**
     * solution 1: recusion top down
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
     * Memory Usage: 38.7 MB, less than 92.62% of Java online submissions for Path Sum.
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        return help(root, sum);
    }

    private boolean help(TreeNode node, int sum) {
        // key: use "-" instead of keeping "+"
        sum -= node.val;

        if (node.left == null && node.right == null) {
            return sum == 0;
        }

        if (node.left != null && help(node.left, sum))
            return true;

        if (node.right != null && help(node.right, sum))
            return true;

        return false;
    }

}
