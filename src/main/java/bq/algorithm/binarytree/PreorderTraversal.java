package bq.algorithm.binarytree;

import java.util.ArrayList;

public class PreorderTraversal {

	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();

		if ( root == null) {
			return result;
		}
		
		ArrayList<Integer> left = preorderTraversal(root.left);
		ArrayList<Integer> right = preorderTraversal(root.right);
		
		result.add(root.val);
		result.addAll(left);
		result.addAll(right);
		
		return result;
	}
	
}
