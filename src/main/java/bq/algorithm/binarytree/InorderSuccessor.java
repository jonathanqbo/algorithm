package bq.algorithm.binarytree;

public class InorderSuccessor {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if( root.left == p || root.right == p) 
			return root;
		
		TreeNode left = inorderSuccessor(root.left, p);
		TreeNode right = inorderSuccessor(root.right, p);
		
		if ( left != null ) {
			return left;
		}
		
		if (right != null ) {
			return right;
		}
		
		return null;
	}
	
}
