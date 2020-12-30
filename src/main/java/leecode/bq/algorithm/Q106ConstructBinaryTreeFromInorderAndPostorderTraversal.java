package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/27/20 8:44 PM
 */
public class Q106ConstructBinaryTreeFromInorderAndPostorderTraversal {

    Map<Integer, Integer> ioValueToIndex = new HashMap();

    /**
     * Runtime: 1 ms, faster than 96.20% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
     * Memory Usage: 39 MB, less than 56.27% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            ioValueToIndex.put(inorder[i], i);
        }

        return helper(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    /**
     *
     * @param inorder
     * @param postorder
     * @param ioStart Start Index in next inorder array
     * @param ioEnd End index in next inorder array
     * @param poRootIndex Root value index in postorder array
     * @return
     */
    private TreeNode helper(int[] inorder, int[] postorder, int ioStart, int ioEnd, int poRootIndex) {
        if (ioStart > ioEnd)
            return null;

        int rootValue = postorder[poRootIndex];
        int ioRootIndex = ioValueToIndex.get(rootValue);

        TreeNode node = new TreeNode();
        node.val = rootValue;
        node.right = helper(inorder, postorder, ioRootIndex + 1, ioEnd, poRootIndex - 1);
        // key: calculate root index in postorder for left sub array.
        node.left = helper(inorder, postorder, ioStart, ioRootIndex - 1, poRootIndex - (ioEnd - ioRootIndex) - 1);

        return node;
    }

}
