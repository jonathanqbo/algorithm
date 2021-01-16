package leecode.bq.algorithm;

import leecode.bq.TreeNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/2/21 2:51 PM
 */
public class Q270ClosestBinarySearchTreeValue {

    /**
     * solution: binary search
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Closest Binary Search Tree Value.
     * Memory Usage: 38.8 MB, less than 76.47% of Java online submissions for Closest Binary Search Tree Value.
     *
     * @param root
     * @param target
     * @return
     */
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;

        TreeNode node = root;
        while (node != null) {
            closest = Math.abs(node.val - target) < Math.abs(closest - target) ? node.val : closest;
            node = target < node.val ? node.left : node.right;
        }

        return closest;
    }

}
