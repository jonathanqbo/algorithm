package bq.algorithm.binarytree;

public class ValidateBalacedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		ReturnValue result = validatedBalance(root);
		return result.isBalanced;
	}
	
	public ReturnValue validatedBalance(TreeNode root) {
		if ( root == null ) {
			return new ReturnValue(true, 0);
		}
		
		ReturnValue leftResult = validatedBalance(root.left);
		if (!leftResult.isBalanced) {
			return new ReturnValue(false, -1);
		}
		
		ReturnValue rightResult = validatedBalance(root.right);
		if ( !rightResult.isBalanced ) {
			return new ReturnValue(false, -1);
		}
		
		if ( Math.abs( rightResult.depth - leftResult.depth) <= 1) {
			return new ReturnValue(true, Math.max(rightResult.depth, leftResult.depth) + 1);
		}
		
		return new ReturnValue(false, -1);
	}
	
	class ReturnValue {
		public boolean isBalanced;
		public int depth;
		public ReturnValue(boolean isBalanced, int depth) {
			super();
			this.isBalanced = isBalanced;
			this.depth = depth;
		}
	}
	
}
