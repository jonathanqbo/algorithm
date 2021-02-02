package leecode.bq.algorithm;

import leecode.bq.TreeNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/16/21 3:46 PM
 */
public class Q108ConvertSortedArrayToBinarySearchTree {

    /**
     * solution: recursion
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     * Memory Usage: 38.6 MB, less than 77.92% of Java online submissions for Convert Sorted Array to Binary Search Tree.
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int mid = start + (end - start) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, start, mid - 1);
        node.right = helper(nums, mid + 1, end);

        return node;
    }

}
