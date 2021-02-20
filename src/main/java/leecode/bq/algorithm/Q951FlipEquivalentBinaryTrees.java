package leecode.bq.algorithm;

import leecode.bq.TreeNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/14/21 9:02 PM
 */
public class Q951FlipEquivalentBinaryTrees {

    /**
     * solution: recursion
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Flip Equivalent Binary Trees.
     * Memory Usage: 36.8 MB, less than 53.47% of Java online submissions for Flip Equivalent Binary Trees.
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        return (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))
                || (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right));
    }

}
