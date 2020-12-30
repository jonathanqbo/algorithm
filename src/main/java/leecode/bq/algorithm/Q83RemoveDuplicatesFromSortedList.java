package leecode.bq.algorithm;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/25/20 8:14 PM
 */
public class Q83RemoveDuplicatesFromSortedList {

    /**
     * solution 1: two pointers
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
     * Memory Usage: 38.4 MB, less than 50.36% of Java online submissions for Remove Duplicates from Sorted List.
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = fast;
            }

            fast = fast.next;
        }

        // remember to handle the end of list
        slow.next = null;

        return head;
    }

    /**
     * solution two:
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
     * Memory Usage: 38.4 MB, less than 50.36% of Java online submissions for Remove Duplicates from Sorted List.
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;

        while(cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
