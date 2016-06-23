package bq.algorithm.linkedlist;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
	
	public static void print(ListNode head) {
		System.out.print("START");
		
		ListNode cur = head;
		while (cur != null) {
			System.out.print("->" + cur.val);
			cur = cur.next;
		}
		
		System.out.println("-->END");
	}
}
