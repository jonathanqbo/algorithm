package leecode.bq.datastructure.binarytree;

import leecode.bq.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 *
 * Pre-order traversal is to visit the root first. Then traverse the left subtree. Finally, traverse the right subtree.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/26/20 10:35 AM
 */
public class PreOderTraversal {

    /**
     * solution 1: recursion
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     * Memory Usage: 38.9 MB, less than 5.15% of Java online submissions for Binary Tree Preorder Traversal.
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList();
        traversRecord(root, result);

        return result;
    }

    private void traversRecord(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        result.add(node.val);

        traversRecord(node.left, result);
        traversRecord(node.right, result);
    }

    /**
     * solution 2: interation
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     * Memory Usage: 39 MB, less than 5.15% of Java online submissions for Binary Tree Preorder Traversal.
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList();
        LinkedList<Integer> result = new LinkedList();

        if (root == null) {
            return result;
        }

        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            result.add(node.val);

            if (node.right != null)
                stack.addLast(node.right);
            if (node.left != null)
                stack.addLast(node.left);
        }

        return result;
    }

}
