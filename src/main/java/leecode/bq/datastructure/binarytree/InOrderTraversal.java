package leecode.bq.datastructure.binarytree;

import leecode.bq.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 *
 * In-order traversal is to traverse the left subtree first. Then visit the root. Finally, traverse the right subtree.
 *
 * Typical scenario: we can retrieve all the data in sorted order using in-order traversal
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/26/20 10:36 AM
 */
public class InOrderTraversal {

    /**
     * solution 1: recursion
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     * Memory Usage: 37.5 MB, less than 28.90% of Java online submissions for Binary Tree Inorder Traversal.
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList();

        traverse(root, result);

        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        traverse(node.left, result);
        result.add(node.val);
        traverse(node.right, result);
    }

    /**
     * solution 2: interation
     *
     * There are two scenarios to handle for each left node: has right node / has no right node.
     * 1. If has right node, need to repeat while-loop to add all its left nodes
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     * Memory Usage: 37.6 MB, less than 17.91% of Java online submissions for Binary Tree Inorder Traversal.
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList();
        if (root == null)
            return result;

        LinkedList<TreeNode> stack = new LinkedList();
        // next node to be add into stack
        TreeNode nextNodeToStack = root;
        while (nextNodeToStack != null || !stack.isEmpty()) {
            while (nextNodeToStack != null) {
                stack.addLast(nextNodeToStack);
                nextNodeToStack = nextNodeToStack.left;
            }

            nextNodeToStack = stack.pollLast();
            result.add(nextNodeToStack.val);

            nextNodeToStack = nextNodeToStack.right;
        }

        return result;
    }

}
