package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:55 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q144BinaryTreePreorderTraversal {

    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            LinkedList<TreeNode> stack = new LinkedList();
            List<Integer> result = new LinkedList();

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

}
