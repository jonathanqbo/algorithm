package bq.algorithm.linkedlist;

public class LinkedListCycleII {
	
	public ListNode detectCycle(ListNode head) {  
		if (head == null || head.next == null) {
			return null;
		}
		
		// Two pointers: fast pointer is 1 step faster than slow pointer
		// so fast pointer will catch slow pointer.
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != slow && fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		if (slow != fast) {
			return null;
		}
		
		// Two pointers: 
		// 1) pointer from start  2) pointer from meet node
		ListNode start = head;
		ListNode meet = slow;
		while (start != meet.next) {
			start = start.next;
			meet = meet.next;
		}
		
		return start;
	}

}
