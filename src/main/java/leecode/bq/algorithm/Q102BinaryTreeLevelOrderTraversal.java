package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:50 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q102BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelResult = new LinkedList();

            int i = 0;
            int length = queue.size();
            while(i < length) {
                TreeNode node = queue.poll();
                levelResult.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);

                i++;
            }

            result.add(levelResult);
        }

        return result;
    }

}