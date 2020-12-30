package leecode.bq.algorithm;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/30/20 4:16 PM
 */
public class Q61RotateList {

    /**
     * note: if want a simple code, just simply get list size in first loop.
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate List.
     * Memory Usage: 38.2 MB, less than 90.02% of Java online submissions for Rotate List.
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // move fast pointer k steps or until end
        ListNode fast = head;
        int i = 0;
        while (i < k && fast.next != null) {
            i++;
            fast = fast.next;
        }

        // if k < size: just need one-loop
        if (i == k) {
            ListNode slow = head;
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            ListNode newHead = slow.next;
            fast.next = head;
            slow.next = null;

            return newHead;
        }

        int size = i + 1;

        // if k % size == 0: list stay same
        int newK = k % size;
        if (newK == 0) {
            return head;
        }

        // if k > size:
        ListNode tail = fast;
        tail.next = head;

        ListNode node = head;
        for (int j = 0; j < (size - newK - 1); j++) {
            node = node.next;
        }

        ListNode newHead = node.next;
        node.next = null;

        return newHead;
    }

}
