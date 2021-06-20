package leecode.bq.algorithm;

import leecode.bq.TreeNode;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/20/21 10:24 AM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q1120MaximumAverageSubtree {

    class Solution {
        double maxAvg = Double.MIN_VALUE;

        public double maximumAverageSubtree(TreeNode root) {
            dfs(root);
            return maxAvg;
        }

        private SubTreeStats dfs(TreeNode node) {
            if (node == null) {
                return new SubTreeStats(0, 0);
            }

            SubTreeStats left = dfs(node.left);
            SubTreeStats right = dfs(node.right);

            SubTreeStats stats = new SubTreeStats(left.amount + right.amount + 1, left.sum + right.sum + node.val);

            double avg = ((double)stats.sum) / stats.amount;
            maxAvg = Math.max(maxAvg, avg);

            return stats;
        }
    }

    class SubTreeStats {
        int amount;
        int sum;

        public SubTreeStats(int amount, int sum) {
            this.amount = amount;
            this.sum = sum;
        }
    }

}
