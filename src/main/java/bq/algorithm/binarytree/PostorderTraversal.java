package bq.algorithm.binarytree;

import java.util.ArrayList;

public class PostorderTraversal {

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		if ( root == null ) {
			return result;
		}
		
		result.addAll(postorderTraversal(root.left));
		result.addAll(postorderTraversal(root.right));
		result.add(root.val);
		
		return result;
	}
	
}
