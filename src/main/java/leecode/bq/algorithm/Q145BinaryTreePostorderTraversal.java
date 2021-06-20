package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:56 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q145BinaryTreePostorderTraversal {

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList();
            LinkedList<TreeNode> stack = new LinkedList();
            if (root == null)
                return result;

            TreeNode cur = root; // next node to visit
            TreeNode pre = null; // former node being popped
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.addLast(cur);
                    cur = cur.left;
                }

                cur = stack.getLast();
                cur = cur.right;
                if (cur == null || cur == pre) {
                    pre = stack.pollLast();
                    result.add(pre.val);
                    cur = null;
                }
            }

            return result;
        }
    }

}