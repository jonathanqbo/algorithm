package leecode.bq.algorithm;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
 * Memory Usage: 39.1 MB, less than 67.13% of Java online submissions for Linked List Cycle II.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/29/20 11:09 AM
 */
public class Q142LinkedListCycleII {

    /**
     * solution:
     * 1. find the join node using slow / fast pointers
     * 2. find the cycle start node using slow / slow pointers
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // find intersection node
        ListNode join = findIntersectionNode(head);

        if (join == null) {
            return null;
        }

        // find cycle start node
        ListNode p1 = head;
        ListNode p2 = join;
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    private ListNode findIntersectionNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return slow;
            }
        }

        return null;
    }

}
