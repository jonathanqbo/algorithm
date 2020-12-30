package leecode.bq.algorithm;

import leecode.bq.TreeNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/26/20 10:04 AM
 */
public class Q104MaximumDepthOfBinaryTree {

    /**
     * solution 1: recursion
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
     * Memory Usage: 40.4 MB, less than 5.19% of Java online submissions for Maximum Depth of Binary Tree.
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
