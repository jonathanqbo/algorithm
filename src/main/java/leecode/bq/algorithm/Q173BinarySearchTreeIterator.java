package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:57 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q173BinarySearchTreeIterator {

    /**
     * solution: lazy load, only all all left nodes in inorder traversal
     * <p>
     * key: follow same pattern as inorder non-recursion traversal
     * <p>
     * in-order:   left-root-right
     * pre-oder:   root-left-right
     * post-order: left-right-root
     */

    class BSTIterator {
        Deque<TreeNode> stack = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode curNode = stack.pop();

            TreeNode node = curNode.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            return curNode.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

}

