package bq.algorithm.linkedlist;

public class SortList {
	
	public ListNode sortList(ListNode head) {  
		if (head == null) {
			return null;
		}
		
		ListNode rightHead = split(head);
		
		ListNode left = sortList(head);
		ListNode right = sortList(rightHead);
		
		return merge(left, right);
	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		
		ListNode cur = dummy;
		ListNode cur1 = left;
		ListNode cur2 = right;
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
		
		return dummy.next;
	}

	private ListNode split(ListNode head) {
		ListNode fast = head.next, slow = head;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode newHead = slow.next;
		slow.next = null;
		
		return newHead;
	}

}
