package bq.algorithm.linkedlist;

public class RemoveDuplicatesFromSortedListII {

	public static ListNode deleteDuplicates(ListNode head) {
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode curNode = dummy;
		while (curNode.next != null) {
			if ( curNode.next.next != null && curNode.next.val == curNode.next.next.val) {
				int val = curNode.next.val;
				while (curNode.next != null && curNode.next.val == val) {
					curNode.next = curNode.next.next;
				}
			}
			else {
				curNode = curNode.next;
			}
		}
		
		return dummy.next;
	}
	
}
