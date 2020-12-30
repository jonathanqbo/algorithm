package leecode.bq.algorithm;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/29/20 4:54 PM
 */
public class Q206ReverseLinkedList {

    /**
     * solution: 1 → 2 → 3 → Ø  ====>  Ø ← 1 ← 2 ← 3.
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
     * Memory Usage: 38.6 MB, less than 78.64% of Java online submissions for Reverse Linked List.
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur!= null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * solution 2: swipe with head
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        while (pre.next != null) {
            ListNode cur = pre.next;
            pre.next = cur.next;
            cur.next = head;
            head = cur;
        }

        return head;
    }

}
