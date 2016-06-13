package bq.algorithm.binarytree;

public class MaxPathSum {

	public int maxPathSum(TreeNode root) {
		if ( root == null ) {
			return 0;
		}
		
		Result result = maxPathSumRecursion(root);
		return result.node2node;
	}
	
	private Result maxPathSumRecursion(TreeNode root) {
		if ( root == null ) {
			return new Result(Integer.MIN_VALUE, Integer.MIN_VALUE);
		}
		
		Result left = maxPathSumRecursion(root.left);
		Result right = maxPathSumRecursion(root.right);
		
		int root2node = Math.max(0, left.node2node) + Math.max(0, right.node2node) + root.val;
		
		int node2node = Math.max(0, Math.max(left.root2node, right.root2node));
		node2node = Math.max(node2node, Math.max(0, root2node));
		
		return new Result(node2node, root2node);
	}
	
	class Result {
		int node2node = Integer.MIN_VALUE;
		int root2node = Integer.MIN_VALUE;
		
		public Result(int node2node, int root2node) {
			super();
			this.node2node = node2node;
			this.root2node = root2node;
		}

	}
	
}
