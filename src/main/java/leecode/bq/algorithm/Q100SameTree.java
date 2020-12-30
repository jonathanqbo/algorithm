package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/25/20 9:03 PM
 */
public class Q100SameTree {
    /**
     * solution 1: recursion
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
     * Memory Usage: 36.3 MB, less than 65.80% of Java online submissions for Same Tree.
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * solution 2: Iteration using Deque
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
     * Memory Usage: 36.5 MB, less than 46.64% of Java online submissions for Same Tree.
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (!isSameNode(p, q))
            return false;

        if (p == null && q == null)
            return true;

        // Deque doesn't support to add NULL value
        Deque<TreeNode> dq1 = new ArrayDeque<>();
        Deque<TreeNode> dq2 = new ArrayDeque<>();

        dq1.addFirst(p);
        dq2.addFirst(q);

        while (!dq1.isEmpty() && !dq2.isEmpty()) {
            TreeNode n1 = dq1.removeLast();
            TreeNode n2 = dq2.removeLast();

            if (!isSameNode(n1.left, n2.left))
                return false;
            if (!isSameNode(n1.right, n2.right))
                return false;

            if (n1.left != null) {
                dq1.addFirst(n1.left);
                dq2.addFirst(n2.left);
            }
            if (n1.right != null) {
                dq1.addFirst(n1.right);
                dq2.addFirst(n2.right);
            }
        }

        return true;
    }

    private boolean isSameNode(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else if (p.val != q.val)
            return false;

        return true;
    }

}
