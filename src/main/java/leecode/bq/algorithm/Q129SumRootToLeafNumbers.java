package leecode.bq.algorithm;

import leecode.bq.TreeNode;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:51 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q129SumRootToLeafNumbers {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, root.val);
        return sum;
    }

    private void dfs(TreeNode node, int pathNum) {
        if (node.left == null && node.right == null) {
            sum += pathNum;
            return;
        }

        if (node.left != null) {
            dfs(node.left, pathNum * 10 + node.left.val);
        }

        if (node.right != null) {
            dfs(node.right, pathNum * 10 + node.right.val);
        }
    }
}
