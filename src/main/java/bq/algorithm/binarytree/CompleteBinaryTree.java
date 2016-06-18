package bq.algorithm.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
	private Queue<TreeNode> queue = new LinkedList();
	
	public boolean isComplete(TreeNode root) {
		Result result = help(root);
		return result.isComplete;
	}
	
	private Result help(TreeNode node) {
		if ( node == null ) {
			return new Result(true, true, 0);
		}
		
		Result left = help(node.left);
		if(!left.isComplete) {
			return new Result(false, false, -1);
		}
		
		Result right = help(node.right);
		if( !right.isComplete ) {
			return new Result(false, false, -1);
		}
		
		int depth = left.depth + 1;
		
		// depth equal: left should be full
		if ( left.depth == right.depth ) {
			if ( !left.isFull) {
				return new Result(false, false, depth);
			}
			return new Result(true, right.isFull, depth);
		}
		// left depth is 1 more than right: right should be full
		else if (left.depth == right.depth + 1 ) {
			if ( !right.isFull ) {
				return new Result(false, false, depth);
			}
			return new Result(true, false, depth);
		}
		else {
			return new Result( false, false, -1);
		}
		
	}
	
	class Result {
		boolean isComplete;
		boolean isFull;
		int depth;

		public Result(boolean isComplete, boolean isFull, int depth) {
			super();
			this.isComplete = isComplete;
			this.isFull = isFull;
			this.depth = depth;
		}
		
	}
	

}
