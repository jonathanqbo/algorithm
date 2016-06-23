package bq.algorithm.linkedlist;

import bq.algorithm.binarytree.TreeNode;

public class ConvertSortedListtoBalancedBST {
	
	private ListNode curNode = null;

	public TreeNode sortedListToBST(ListNode head) {  
		if (head == null) {
			return null;
		}
		
		curNode = head;
		int size = getLinkedListSize(head);
		
		return sortedList2BST(size);
	}

	private TreeNode sortedList2BST(int size) {
		if (size <= 0) {
			return null;
		}
		
		TreeNode leftNode = sortedList2BST(size/2);
		
		TreeNode root = new TreeNode(curNode.val);
		curNode = curNode.next;
		
		TreeNode rightNode = sortedList2BST(size - size/2 - 1);
		
		root.left = leftNode;
		root.right = rightNode;
		return root;
	}

	private int getLinkedListSize(ListNode head) {
		int size = 0;
		
		while (head != null) {
			size++;
			head = head.next;
		}
		
		return size;
	}
	
}
