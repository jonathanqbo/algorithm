package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/25/20 10:10 PM
 */
public class Q101SymmetricTree {

    /**
     * solution 1: recursion
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
     * Memory Usage: 37 MB, less than 75.12% of Java online submissions for Symmetric Tree.
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;

        return (left.val == right.val)
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }

    /**
     * solution: iteration using LinkedList
     * LinkedList supports null, but has worse memory than ArrayDeque
     *
     * Runtime: 1 ms, faster than 24.19% of Java online submissions for Symmetric Tree.
     * Memory Usage: 38.4 MB, less than 18.72% of Java online submissions for Symmetric Tree.
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }

}
