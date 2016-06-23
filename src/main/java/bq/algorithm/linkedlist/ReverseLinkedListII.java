package bq.algorithm.linkedlist;

public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m , int n) {
		if (head == null) {
			return null;
		}
		
		// may reverse from head, so use dummy node
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode cur = dummy.next;
		ListNode preM = dummy;
		for(int i = 1; i < m; i++) {
			preM = cur;
			cur = cur.next;
		}
		
		// reverse
		ListNode nodeM = cur;
		ListNode pre = preM;
		for(int i = m; i < n; i++) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		ListNode nodeN = cur;
		ListNode afterN = cur.next;
		
		//
		preM.next = nodeN;
		nodeM.next = afterN;
		
		return dummy.next;
	}
	
}
