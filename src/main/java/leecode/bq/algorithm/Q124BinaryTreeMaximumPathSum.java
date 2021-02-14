package leecode.bq.algorithm;

import leecode.bq.TreeNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/8/21 9:28 PM
 */
public class Q124BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;

    /**
     * solution: define recursion function maxGain(node): max path value that starts from node.
     * Then recurse all node to get all the possible max value based on the function maxGain.
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    /**
     * KEY: maxGain
     * return the max gain that start from node (node value + its left children or right children)
     */
    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // if stop at this node, then max:
        int maxCur = node.val + leftGain + rightGain;
        max = Math.max(max, maxCur);

        // return curNode + either of left or right node or none of them
        return node.val + Math.max(leftGain, rightGain);
    }

}
