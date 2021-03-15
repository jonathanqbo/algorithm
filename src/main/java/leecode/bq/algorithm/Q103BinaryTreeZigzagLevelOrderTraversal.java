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
 * Created on 3/12/21 9:10 PM
 */
public class Q103BinaryTreeZigzagLevelOrderTraversal {

    /**
     * solution: BFS
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     * Memory Usage: 39.4 MB, less than 14.01% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            if (root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            int level = 0;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                LinkedList<Integer> levelList = new LinkedList<>();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    if (level % 2 == 0) {
                        levelList.add(node.val);
                    } else {
                        levelList.offerFirst(node.val);
                    }

                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

                level++;
                result.add(levelList);
            }

            return result;
        }
    }

}
