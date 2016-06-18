package bq.algorithm.binarytree;

import java.util.Stack;

public class BSTIterator {
	
	private Stack<TreeNode> stack = new Stack<>();
	private TreeNode curNode = null;
	
	public BSTIterator(TreeNode root) {
		curNode = root;
    }

    public boolean hasNext() {
    	return stack.isEmpty();
    }
    
    public TreeNode next() {
    	while ( curNode != null ) {
    		stack.push(curNode);
    		curNode = curNode.left;
    	}
    	
    	TreeNode result = stack.pop();
    	curNode = result.right;
    	
    	return result;
    }

}
