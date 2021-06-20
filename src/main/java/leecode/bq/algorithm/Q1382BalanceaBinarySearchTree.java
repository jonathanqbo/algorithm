package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/20/21 10:39 AM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q1382BalanceaBinarySearchTree {

    /**

     solution: BST Inorder to sorted Array, then convert Array to AVL BST

     */

    class Solution {

        public TreeNode balanceBST(TreeNode root) {
            // List<TreeNode> nodes = inorder(root);
            List<TreeNode> nodes = new ArrayList<>();
            inorder(root, nodes);
            return buildBST(nodes, 0, nodes.size() - 1);
        }

        // use recursion drop timecost from 5ms to 2ms
        private void inorder(TreeNode root, List<TreeNode> nodes) {
            if (root.left != null) {
                inorder(root.left, nodes);
            }

            nodes.add(root);

            if (root.right != null) {
                inorder(root.right, nodes);
            }
        }

        private List<TreeNode> inorder2(TreeNode root) {
            List<TreeNode> result = new ArrayList<>();

            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode node = root;

            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }

                node = stack.pop();
                result.add(node);
                node = node.right;
            }

            return result;
        }

        private TreeNode buildBST(List<TreeNode> nodes, int from, int to) {
            if (from > to) {
                return null;
            }

            int mid = from + (to - from) / 2;

            TreeNode root = nodes.get(mid);
            root.left = buildBST(nodes, from, mid - 1);
            root.right = buildBST(nodes, mid + 1, to);

            return root;
        }

    }

}
