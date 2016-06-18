package bq.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {

	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if ( root == null )
			return result;
		
		int leftTarget = target - root.val;
		List<List<Integer>> leftPath = binaryTreePathSum(root.left, leftTarget);
		List<List<Integer>> rightPath = binaryTreePathSum(root.right, leftTarget);
		
		result.addAll(leftPath);
		result.addAll(rightPath);
		
//		result.forEach( path -> path.add(0, root.val));
		for ( int i = 0; i < result.size(); i++ ) {
			result.get(i).add(0, root.val);
		}
		return result;
	}
	
}
