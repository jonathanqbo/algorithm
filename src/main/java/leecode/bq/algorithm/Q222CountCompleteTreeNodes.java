package leecode.bq.algorithm;

import leecode.bq.TreeNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/9/21 11:36 PM
 */
public class Q222CountCompleteTreeNodes {

    /**
     * solution 1: binary search
     * key: binary search on tree
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Complete Tree Nodes.
     * Memory Usage: 41.4 MB, less than 67.73% of Java online submissions for Count Complete Tree Nodes.
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = depth(root);
        // this case is not handled in following code
        if (depth == 0) {
            return 1;
        }

        // last level size
        int fullSizeInLastLevel = (int)Math.pow(2, depth);

        // the last level at least has one node.
        // left: the first index of non-existed node
        int left = 0, right = fullSizeInLastLevel - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nodeExist(mid, depth, fullSizeInLastLevel, root)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // total node amount: 2^(depth) - 1
        return fullSizeInLastLevel - 1 + left;
    }

    private boolean nodeExist(int idx, int depth, int length, TreeNode node) {
        int left = 0, right = length - 1;
        // key: check which side to go
        for (int i = 0; i < depth; i++) {
            int pivot = left + (right - left) / 2;
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            } else {
                node = node.right;
                left = pivot;
            }
        }

        return node != null;
    }

    private int depth(TreeNode root) {
        // note: depth is from 0, total node amount is 2^depth - 1
        int depth = 0;
        while (root.left != null) {
            root = root.left;
            depth++;
        }

        return depth;
    }

    /**
     * solution 2: recursion
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Complete Tree Nodes.
     * Memory Usage: 41.5 MB, less than 56.26% of Java online submissions for Count Complete Tree Nodes.
     *
     * @param root
     * @return
     */
    public int countNodes2(TreeNode root) {
        return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
    }

}
