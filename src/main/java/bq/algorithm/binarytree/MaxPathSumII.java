package bq.algorithm.binarytree;

public class MaxPathSumII {

	public int maxPathSum2(TreeNode root) {
		if ( root == null )
			return 0;
		
		int left = maxPathSum2(root.left);
		int right = maxPathSum2(root.right);
		
		// because the path can be end at any node (not must be leaf nodes)
		return Math.max(Math.max(left, 0), Math.max(right, 0)) + root.val;
	}
	
}
