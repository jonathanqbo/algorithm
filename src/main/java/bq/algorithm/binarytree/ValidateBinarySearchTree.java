package bq.algorithm.binarytree;

public class ValidateBinarySearchTree {
	
	private TreeNode preNode = null;

	public boolean isValidBST(TreeNode root) {
		
		if ( root == null ) {
			return true;
		}
		
//		if ( root.left == null && root.right == null ) {
//			return true;
//		}
		
		if ( !isValidBST(root.left) ) {
			return false;
		}
		
		if ( preNode != null && root.val <= preNode.val) {
			return false;
		}
		
		preNode = root;
		
		if ( !isValidBST(root.right) ) {
			return false;
		}
		
		return true;
	
	}
	
}
