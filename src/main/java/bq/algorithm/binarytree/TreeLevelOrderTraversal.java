package bq.algorithm.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeLevelOrderTraversal {

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		if ( root == null ) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while ( !queue.isEmpty() ) {
			ArrayList<Integer> level = new ArrayList<>();
			
			for ( int i = 0; i < queue.size(); i++ ) {
				TreeNode node = queue.poll();
				
				level.add(node.val);
				
				queue.offer(node.left);
				queue.offer(node.right);
			}
			
			result.add(level);
		}
		
		return result;
	}
	
}
