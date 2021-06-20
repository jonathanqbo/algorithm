package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:49 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q94BinaryTreeInorderTraversal {

    /**
     * Inorder: Left -> Middle -> Right
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        dfs(root, result);

        return result;
    }

    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        dfs(node.left, result);

        result.add(node.val);

        dfs(node.right, result);
    }

}
