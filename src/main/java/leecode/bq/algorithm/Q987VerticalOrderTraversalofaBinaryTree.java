package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.*;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:34 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q987VerticalOrderTraversalofaBinaryTree {

    /**

     solution: BFS + Map<column, List<(row, col, TreeNode)>>

     1. build Map by bfs: column -> List of TreeNode with their row, and keep tracking min col num and max col num
     2. loop from min col num to max col num, and sort each values


     for node (row, col, TreeNode):
     leftnode(row + 1, col - 1, TreeNode.left)
     rightnode(row + 1, col + 1, TreeNode.right)


     time complexity: bfs traversal O(N) + sort each column O(W*H*LogH) => O(NLogH), W is the tree width (total amount of column), H is the height of tree
     space complexity: O(N). keep all nodes in memory

     */

    class Solution {

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            int[] colRange = new int[2];
            Map<Integer, List<RowColTreeNode>> colToNodes = new HashMap<>();

            bfs(root, 0, 0, colToNodes, colRange);

            int minCol = colRange[0];
            int maxCol = colRange[1];

            List<List<Integer>> result = new ArrayList<>();
            for (int i = minCol; i <= maxCol; i++) {
                List<RowColTreeNode> nodes = colToNodes.get(i);
                Collections.sort(nodes, (n1, n2) -> n1.row == n2.row ? n1.node.val - n2.node.val : n1.row - n2.row);

                List<Integer> oneResult = new ArrayList<>();
                for (RowColTreeNode node : nodes) {
                    oneResult.add(node.node.val);
                }

                result.add(oneResult);
            }

            return result;
        }

        private void bfs(TreeNode node, int col, int row, Map<Integer, List<RowColTreeNode>> colToNodes, int[] colRange) {
            Queue<RowColTreeNode> queue = new LinkedList<>();
            queue.offer(new RowColTreeNode(col, row, node));

            while (!queue.isEmpty()) {
                RowColTreeNode curNode = queue.poll();

                colToNodes.computeIfAbsent(curNode.col, k -> new ArrayList<>()).add(curNode);

                if (curNode.col < colRange[0]) {
                    colRange[0] = curNode.col;
                } else if (curNode.col > colRange[1]) {
                    colRange[1] = curNode.col;
                }

                if (curNode.node.left != null) {
                    queue.offer(new RowColTreeNode(curNode.row + 1, curNode.col - 1, curNode.node.left));
                }
                if (curNode.node.right != null) {
                    queue.offer(new RowColTreeNode(curNode.row + 1, curNode.col + 1, curNode.node.right));
                }
            }
        }

        private void dfs(TreeNode node, int col, int row, Map<Integer, List<RowColTreeNode>> colToNodes, int[] colRange) {
            colToNodes.computeIfAbsent(col, k -> new ArrayList<>()).add(new RowColTreeNode(row, col, node));

            if (col < colRange[0]) {
                colRange[0] = col;
            } else if (col > colRange[1]) {
                colRange[1] = col;
            }

            if (node.left != null) {
                dfs(node.left, col - 1, row + 1, colToNodes, colRange);
            }
            if (node.right != null) {
                dfs(node.right, col + 1, row + 1, colToNodes, colRange);
            }
        }

    }

    class RowColTreeNode {
        TreeNode node;
        int row;
        int col;

        public RowColTreeNode(int row, int col, TreeNode node) {
            this.row = row;
            this.col = col;
            this.node = node;
        }
    }

}
