package leecode.bq.algorithm;

import leecode.bq.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/27/20 8:52 PM
 */
public class Q105ConstructBinaryTreeFromPreorderAndInorderTraversal {

    Map<Integer, Integer> ioValueIndex = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            ioValueIndex.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, inorder.length - 1, 0);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int ioStart, int ioEnd, int poRootIndex) {
        if (ioStart > ioEnd) {
            return null;
        }

        int rootValue = preorder[poRootIndex];
        int ioRootIndex = ioValueIndex.get(rootValue);

        TreeNode node = new TreeNode(rootValue);
        node.left = helper(preorder, inorder, ioStart, ioRootIndex - 1, poRootIndex + 1);
        node.right = helper(preorder, inorder, ioRootIndex + 1, ioEnd, poRootIndex + (ioRootIndex - ioStart) + 1);

        return node;
    }

}
