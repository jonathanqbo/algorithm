package leecode.bq.twopointers;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/29/20 4:05 PM
 */
public class Q19RemoveNthNodeFromEndOfList {

    /**

     solution: fast-slow pointers

     key: how many steps the fast pointer need to move at beginning

     note: both of the way of fast pointer moving in solution1 and solution work

     */
    class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode();
            dummy.next = head;

            ListNode fast = dummy, slow = dummy;
            int i = 0;
            // key: nth from end => fast - slow = n
            while (fast != null && i < n) {
                fast = fast.next;
                i++;
            }

            // key: to make fast stop at the last node, here needs to be fast.next
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            // remove node
            slow.next = slow.next.next;

            return dummy.next;
        }

    }



    class Solution1 {
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

}
