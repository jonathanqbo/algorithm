package bq.algorithm.binarytree;

public class MaxDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		if ( root == null ) {
			return 0;
		}
		
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		
		return Math.max(leftDepth, rightDepth);
	}
	
}
