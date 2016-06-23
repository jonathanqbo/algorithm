package bq.algorithm.linkedlist;

public class RemoveNFromLast {

	ListNode removeNthFromEnd(ListNode head, int n) {
		if ( head == null ) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode preDelete = dummy;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        preDelete.next = preDelete.next.next;
        return dummy.next;
	}
	
}
