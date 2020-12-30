package leecode.bq.datastructure.binarytree;

import leecode.bq.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/26/20 8:15 PM
 */
public class BreadFirstTraversal {

    /**
     * solution 1: iteration
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
     * Memory Usage: 39 MB, less than 92.25% of Java online submissions for Binary Tree Level Order Traversal.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> levelResult = new LinkedList();

            int i = 0;
            // Key: keep queue current size to know what nodes are in same level
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
