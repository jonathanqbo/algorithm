package bq.algorithm.binarytree;

import java.util.ArrayList;

public class InorderTraversal {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		if ( root == null ) {
			return result;
		}
		
		result.addAll(inorderTraversal(root.left));
		result.add(root.val);
		result.addAll(inorderTraversal(root.right));
		
		return result;
	}
}
