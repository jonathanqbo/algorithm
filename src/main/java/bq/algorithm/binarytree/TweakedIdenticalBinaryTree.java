package bq.algorithm.binarytree;

public class TweakedIdenticalBinaryTree {

	public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		}
		else if (a == null || b == null ) {
			return false;
		}
		else if ( a.val != b.val ) {
			return false;
		}
		
		boolean isLeftEqual = isTweakedIdentical(a.left, b.right);
		boolean isRightEqual = isTweakedIdentical(a.right, b.left);
		
		return isLeftEqual && isRightEqual;
    }
	
}
