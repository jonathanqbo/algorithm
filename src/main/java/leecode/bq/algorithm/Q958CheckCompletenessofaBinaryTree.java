package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:32 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q958CheckCompletenessofaBinaryTree {

    /**

     solution 1: No nodes after first NULL (by utilizing LinkedList support null value)

     --------

     solution 2: two loops with null node check

     first loop: stop when queue has null
     second loop: values in queue should all be null

     */

    class Solution {

        public boolean isCompleteTree(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (queue.peek() != null) {
                TreeNode node = queue.poll();
                queue.offer(node.left);
                queue.offer(node.right);
            }

            while (!queue.isEmpty() && queue.peek() == null) {
                queue.poll();
            }

            return queue.isEmpty();
        }

    }

    class Solution2 {

        public boolean isCompleteTree(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            boolean metFirstNull = false;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (node == null) {
                    metFirstNull = true;
                    continue;
                }

                if (metFirstNull) {
                    return false;
                }

                queue.offer(node.left);
                queue.offer(node.right);
            }

            return true;
        }

    }

}
