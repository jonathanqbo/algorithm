package bq.algorithm.binarytree;

public class LowestCommonAncestor {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if ( root == null ) {
			return null;
		}
		
		if ( root == A || root == B ) {
			return root;
		}
		
		TreeNode left = lowestCommonAncestor(root.left, A, B);
		TreeNode right = lowestCommonAncestor(root.right, A, B);
		
		if ( left != null && right != null ) {
			return root;
		}
		else if ( left != null ) {
			return left;
		}
		else if ( right != null ) {
			return right;
		}
		
		return null;
	}
	
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode A, TreeNode B) {
		if ( root == null ) {
			return null;
		}
		
		if ( root == A || root == B ) {
			return root;
		}
		
		TreeNode left = lowestCommonAncestor(root.left, A, B);
		TreeNode right = lowestCommonAncestor(root.right, A, B);
		
		if ( left != null && right != null ) {
			return root;
		}
		else if ( left != null ) {
			return left;
		}
		else if ( right != null ) {
			return right;
		}
		
		return null;
	}
	
	
}
