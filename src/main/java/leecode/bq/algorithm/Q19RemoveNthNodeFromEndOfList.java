package leecode.bq.algorithm;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/29/20 4:05 PM
 */
public class Q19RemoveNthNodeFromEndOfList {

    /**
     * solution: two pointers
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
     * Memory Usage: 36.7 MB, less than 96.31% of Java online submissions for Remove Nth Node From End of List.
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // dummy head makes edge cases easier
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Nth: n + 1 gap from the slow pointer to fast pointer
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

}
