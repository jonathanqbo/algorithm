package bq.algorithm.linkedlist;

public class ReorderList {
	
	/**
	 * This code shows three basic operations for List
	 * 
	 * 1. find middle
	 * 2. reverse
	 * 3. merge
	 */
	public void reorderList(ListNode head) {  
		if (head == null) {
			return;
		}
		
		ListNode rightHead = splitInMiddle(head);
		rightHead = reverse(rightHead);
		
		merge(head, rightHead);
    }

	private void merge(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		
		ListNode cur1 = head1;
		ListNode cur2 = head2;
		ListNode cur = dummy;
		while (cur1 != null && cur2 != null) {
			if (cur1.val < cur2.val) {
				cur.next = cur1;
				cur1 = cur1.next;
			}
			else {
				cur.next = cur2;
				cur2 = cur2.next;
			}
			
			cur = cur.next;
		}
		
		if (cur1 != null) {
			cur.next = cur1;
		}
		else {
			cur.next = cur2;
		}
		
//		return dummy.next;
	}

	private ListNode splitInMiddle(ListNode head) {
		// slow is the pre one of middle node
		// if initialize fast=header.next, the first list will have more nodes
		ListNode fast = head.next;		
		ListNode slow = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode newHead = slow.next;
		// do split
		slow.next = null;
		
		return newHead;
	}

	private ListNode reverse(ListNode rightHead) {
		ListNode pre = null;
		ListNode cur = rightHead;
		while (cur != null) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		
		return pre;
	}
	
}
