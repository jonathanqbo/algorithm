package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/14/21 11:04 PM
 */
public class Q863AllNodesDistanceKinBinaryTree {

    /**
     * solution: convert to graph, then do DFS
     *
     * Runtime: 14 ms, faster than 78.09% of Java online submissions for All Nodes Distance K in Binary Tree.
     * Memory Usage: 38.9 MB, less than 89.45% of Java online submissions for All Nodes Distance K in Binary Tree.
     */
    class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            Map<TreeNode, TreeNode> parents = new HashMap<>();
            dfs(root, null, parents);

            Set<TreeNode> visited = new HashSet<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(target);

            List<Integer> result = new ArrayList<>();
            int level = 0;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    visited.add(node);

                    if (level == K) {
                        result.add(node.val);
                    }

                    // left node
                    if (node.left != null && !visited.contains(node.left)) {
                        queue.offer(node.left);
                    }
                    // right node
                    if (node.right != null && !visited.contains(node.right)) {
                        queue.offer(node.right);
                    }
                    // parent node
                    if (parents.containsKey(node)) {
                        TreeNode parentNode = parents.get(node);
                        if (!visited.contains(parentNode)) {
                            queue.offer(parentNode);
                        }
                    }
                }

                level++;
            }

            return result;
        }

        public void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parents) {
            if (node == null) {
                return;
            }

            if (parent != null) {
                parents.put(node, parent);
            }

            dfs(node.left, node, parents);
            dfs(node.right, node, parents);
        }
    }

}
