package bq.algorithm.binarytree;

public class InsertNodeBST {

	public TreeNode insertNode(TreeNode root, TreeNode node) {
		if ( root == null ) {
			return node;
		}
		
		TreeNode curNode = root;
		TreeNode parentNode = curNode;
		while ( curNode != null ) {
			parentNode = curNode;
			
			if ( node.val < curNode.val ) {
				curNode = curNode.left;
			}
			else {
				curNode = curNode.right;
			}
		}
		
		if (node.val < parentNode.val ) {
			parentNode.left = node;
		}
		else {
			parentNode.right = node;
		}
		
		return root;
	}
	
}
