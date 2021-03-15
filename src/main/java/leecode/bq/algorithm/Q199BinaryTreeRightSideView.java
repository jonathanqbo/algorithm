package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/10/21 11:24 AM
 */
public class Q199BinaryTreeRightSideView {

    /**
     * solution 1: DFS
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Right Side View.
     * Memory Usage: 37.7 MB, less than 46.94% of Java online submissions for Binary Tree Right Side View.
     *
     */
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            if (root == null) {
                return result;
            }

            helper(root, 0, result);

            return result;
        }

        private void helper(TreeNode node, int level, List<Integer> result) {
            // KEY: only keep the first node in same level
            if (level == result.size()) {
                result.add(node.val);
            }

            // visit right first, so the right node always picked first
            if (node.right != null) {
                helper(node.right, level + 1, result);
            }

            if (node.left != null) {
                helper(node.left, level + 1, result);
            }
        }
    }


    /**
     * solution 2: BFS
     *
     * Runtime: 1 ms, faster than 77.90% of Java online submissions for Binary Tree Right Side View.
     * Memory Usage: 37.4 MB, less than 85.34% of Java online submissions for Binary Tree Right Side View.
     *
     */
    class Solution2 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();

                    if (i == levelSize - 1) {
                        result.add(node.val);
                    }

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }

            return result;
        }

    }

}
