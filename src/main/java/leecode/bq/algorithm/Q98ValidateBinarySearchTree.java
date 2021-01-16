package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.LinkedList;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/16/21 10:51 AM
 */
public class Q98ValidateBinarySearchTree {

    /**
     * solution 4: inorder iteration
     *
     * Runtime: 2 ms, faster than 10.23% of Java online submissions for Validate Binary Search Tree.
     * Memory Usage: 38.5 MB, less than 70.50% of Java online submissions for Validate Binary Search Tree.
     *
     * @param root
     * @return
     */
    public boolean isValidBST4(TreeNode root) {
        return inorder2(root);
    }

    public boolean inorder2(TreeNode node) {
        if (node == null) {
            return true;
        }

        LinkedList<TreeNode> stack = new LinkedList();
        TreeNode pre = null;
        while (!stack.isEmpty() || node != null) {
            // left
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            // visit
            TreeNode cur = stack.pop();
            if (pre != null && cur.val <= pre.val) {
                return false;
            }
            pre = cur;

            // right
            node = cur.right;
        }

        return true;
    }

    private TreeNode pre;

    /**
     * solution 3: inorder with global variable
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
     * Memory Usage: 40.9 MB, less than 13.71% of Java online submissions for Validate Binary Search Tree.
     *
     * @param root
     * @return
     */
    public boolean isValidBST3(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {
        if (node == null) {
            return true;
        }

        // left
        if (!inorder(node.left)) {
            return false;
        }

        // node
        if (pre != null && node.val <= pre.val) {
            return false;
        }

        pre = node;

        // right
        return inorder(node.right);
    }

    /**
     * solution 1: recursion
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
     * Memory Usage: 41.5 MB, less than 6.68% of Java online submissions for Validate Binary Search Tree.
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root.left, null, root.val) && helper(root.right, root.val, null);
    }

    private boolean helper(TreeNode node, Integer lowerLimit, Integer upperLimit) {
        if (node == null) {
            return true;
        }

        if (lowerLimit != null && node.val <= lowerLimit) {
            return false;
        }
        if (upperLimit != null && node.val >= upperLimit) {
            return false;
        }

        return helper(node.left, lowerLimit, node.val) && helper(node.right, node.val, upperLimit);
    }

    /**
     * solution 2: recursion
     *
     * Runtime: 1 ms, faster than 33.58% of Java online submissions for Validate Binary Search Tree.
     * Memory Usage: 40.7 MB, less than 17.28% of Java online submissions for Validate Binary Search Tree.
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (!isValidBST(root.right)) {
            return false;
        }

        // get most right in left side
        if (root.left != null) {
            TreeNode left = root.left;
            while (left.right != null) {
                left = left.right;
            }
            if (left.val >= root.val) {
                return false;
            }
        }

        // get most left in right side
        if (root.right != null) {
            TreeNode right = root.right;
            while (right.left != null) {
                right = right.left;
            }
            if (right.val <= root.val) {
                return false;
            }
        }

        return true;
    }

}
