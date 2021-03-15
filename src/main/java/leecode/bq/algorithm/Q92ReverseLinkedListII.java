package leecode.bq.algorithm;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/12/21 2:58 PM
 */
public class Q92ReverseLinkedListII {

    /**
     *
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
     * Memory Usage: 36.5 MB, less than 80.19% of Java online submissions for Reverse Linked List II.
     *
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode newHead = new ListNode();
            newHead.next = head;

            ListNode slow = newHead;
            ListNode fast = newHead;

            for (int i = 0; i < right - left + 1; i++) {
                fast = fast.next;
            }

            for (int i = 0; i < left - 1; i++) {
                slow = slow.next;
                fast = fast.next;
            }

            ListNode last = fast;
            ListNode nextLast = fast.next;

            ListNode first = slow.next;
            ListNode second = first.next;
            while (first != last) {
                ListNode tmp = second.next;
                second.next = first;
                first = second;
                second = tmp;
            }

            slow.next.next = nextLast;
            slow.next = fast;

            return newHead.next;
        }
    }

}
