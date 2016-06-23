package bq.algorithm.linkedlist;

public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		
		ListNode leftListHead = new ListNode(0);
		ListNode rightListHead = new ListNode(0);
		
		ListNode curNode = head;
		ListNode leftCurNode = leftListHead;
		ListNode rightCurNode = rightListHead;
		while ( curNode != null ) {
			ListNode tmp = curNode;
			curNode = curNode.next;
			
			if ( tmp.val < x ) {
				leftCurNode.next = tmp;
				leftCurNode = leftCurNode.next;
			}
			else {
				rightCurNode.next = tmp;
				rightCurNode = rightCurNode.next;
			}
		}
		
		leftCurNode.next = rightListHead.next;
		rightCurNode.next = null;
		return leftListHead.next;
    }
	
}
