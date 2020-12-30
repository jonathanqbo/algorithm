package leecode.bq.algorithm;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
 * Memory Usage: 38.6 MB, less than 99.56% of Java online submissions for Linked List Cycle.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/29/20 11:09 AM
 */
public class Q141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
