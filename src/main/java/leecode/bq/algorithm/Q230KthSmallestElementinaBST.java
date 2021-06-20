package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 3/20/21 8:30 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q230KthSmallestElementinaBST {

    /**
     * solution 1: Iterator
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        int amount = 0;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            amount++;
            if (amount == k) {
                return node.val;
            }

            node = node.right;
        }

        throw new IllegalArgumentException();
    }


    /**
     * solution 2: recursion
     */
    class Solution2 {
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> sequence = new ArrayList<>();
            dfsInorder(root, sequence, k);
            return sequence.get(k - 1);
        }

        private void dfsInorder(TreeNode node, List<Integer> sequence, int k) {
            if (node == null) {
                return;
            }

            dfsInorder(node.left, sequence, k);

            sequence.add(node.val);
            // NOTE: this return wont stop recurring back all the nodes that are alrready in stack
            // so finally, still need to use sequence.get(k) to get the result
            if (sequence.size() == k + 1) {
                return;
            }

            dfsInorder(node.right, sequence, k);
        }
    }

}


