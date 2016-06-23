package bq.algorithm.linkedlist;

import java.util.List;

public class MergeKSortedLists {

	public ListNode mergeKLists(List<ListNode> lists) {  
		
		if ( lists == null || lists.isEmpty()) {
			return null;
		}
		
		if (lists.size() == 1) {
			return lists.get(0);
		}
		
		// For better performance, don't merge each list with result.
		// merge two two separately
		/*
		ListNode result = lists.get(0);
		for (int i = 1; i < lists.size(); i++) {
			result = merge2Lists(result, lists.get(i));
		}
		*/
		
		// 
		return mergeKLists(lists, 0, lists.size());
	}
	

	private ListNode mergeKLists(List<ListNode> lists, int start, int end) {
		if ( end == start + 1 ) {
			return lists.get(start);
		}
		
		int mid = start + (end - start) / 2;
		ListNode left = mergeKLists(lists, start, mid);
		ListNode right = mergeKLists(lists, mid, end);
		
		return merge2Lists(left, right);
	}

	private ListNode merge2Lists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(0);
		
		ListNode curNode1 = list1;
		ListNode curNode2 = list2;
		ListNode curNode = dummy;
		while (curNode1 != null && curNode2 != null) {
			if (curNode1.val <= curNode2.val) {
				curNode.next = curNode1;
				curNode1 = curNode1.next;
			}
			else {
				curNode.next = curNode2;
				curNode2 = curNode2.next;
			}
			
			curNode = curNode.next;
		}
		
		if (curNode1 != null) {
			curNode.next = curNode1;
		}
		else {
			curNode.next = curNode2;
		}
		
		return dummy.next;
	}
	
}
