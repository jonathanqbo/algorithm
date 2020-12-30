package leecode.bq.datastructure.binarytree;

import leecode.bq.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 *
 * Post-order traversal is to traverse the left subtree first. Then traverse the right subtree. Finally, visit the root.
 *
 * Typical scenario: post-order is widely use in mathematical expression.
 *
 * Example:
 *
 *     +
 *   /   \
 *  8     6
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/26/20 10:44 AM
 */
public class PostOrderTraversal {

    /**
     * solution 1: recursion
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
     * Memory Usage: 37.2 MB, less than 62.57% of Java online submissions for Binary Tree Postorder Traversal.
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList();
        traverse(root, result);

        return result;
    }

    private void traverse(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        if (node.left != null)
            traverse(node.left, result);

        if (node.right != null)
            traverse(node.right, result);

        result.add(node.val);
    }

    /**
     * solution 2: iteration
     *
     * Key: to pop a node from stack, need to check if it has no right node or its right node has been visited.
     * The difficulty is how to check if right node is visited.
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
     * Memory Usage: 37 MB, less than 89.38% of Java online submissions for Binary Tree Postorder Traversal.
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList();
        LinkedList<TreeNode> stack = new LinkedList();
        if (root == null)
            return result;

        TreeNode nextToStack = root; // next node to be add to stack
        TreeNode prePoppedFromStack = null; // former node being popped
        while (nextToStack != null || !stack.isEmpty()) {
            while (nextToStack != null) {
                stack.addLast(nextToStack);
                nextToStack = nextToStack.left;
            }

            nextToStack = stack.getLast();
            nextToStack = nextToStack.right;
            if (nextToStack == null || nextToStack == prePoppedFromStack) {
                prePoppedFromStack = stack.pollLast();
                result.add(prePoppedFromStack.val);
                nextToStack = null;
            }
        }

        return result;
    }

}
