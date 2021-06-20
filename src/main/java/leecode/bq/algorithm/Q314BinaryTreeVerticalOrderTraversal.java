package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.*;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 9:56 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q314BinaryTreeVerticalOrderTraversal {

    /**

     solution: BFS

     KEY: build row, col along with BFS, and keep tracking the minCol.

     */

    class Solution {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            Map<Integer, List<Integer>> colToNodes = new HashMap<>();
            int minCol = 0;

            Queue<RowColTreeNode> queue = new LinkedList<>();
            queue.offer(new RowColTreeNode(0, 0, root));

            while (!queue.isEmpty()) {
                RowColTreeNode node = queue.poll();

                minCol = Math.min(node.col, minCol);
                colToNodes.computeIfAbsent(node.col, k -> new ArrayList<>()).add(node.node.val);

                if (node.node.left != null) {
                    queue.offer(new RowColTreeNode(node.row + 1, node.col - 1, node.node.left));
                }
                if (node.node.right != null) {
                    queue.offer(new RowColTreeNode(node.row + 1, node.col + 1, node.node.right));
                }
            }

            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < colToNodes.size(); i++) {
                result.add(colToNodes.get(minCol + i));
            }

            return result;
        }
    }

    class RowColTreeNode {
        int row;
        int col;
        TreeNode node;

        public RowColTreeNode(int row, int col, TreeNode node) {
            this.row = row;
            this.col = col;
            this.node = node;
        }
    }

}
