package leecode.bq.algorithm;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/29/20 8:01 PM
 */
public class Q203RemoveLinkedListElements {

    /**
     * Runtime: 1 ms, faster than 75.37% of Java online submissions for Remove Linked List Elements.
     * Memory Usage: 39.5 MB, less than 98.20% of Java online submissions for Remove Linked List Elements.
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }

            cur = cur.next;
        }

        // return dummy.next in case head got deleted
        return dummy.next;
    }

}
