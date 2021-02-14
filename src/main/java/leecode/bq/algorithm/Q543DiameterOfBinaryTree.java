package leecode.bq.algorithm;

import leecode.bq.TreeNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/13/21 3:55 PM
 */
public class Q543DiameterOfBinaryTree {

    int diameter = 0;

    /**
     * solution: calculate max diameter during depth search
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
     * Memory Usage: 38.8 MB, less than 71.74% of Java online submissions for Diameter of Binary Tree.
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        depth(root);

        return diameter;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int d1 = depth(node.left);
        int d2 = depth(node.right);
        diameter = Math.max(diameter, d1 + d2);

        return Math.max(d1, d2) + 1;
    }

}
