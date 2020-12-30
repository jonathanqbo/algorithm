package leecode.bq.algorithm;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/29/20 10:05 PM
 */
public class Q2AddTwoNumbers {

    /**
     * Runtime: 2 ms, faster than 79.01% of Java online submissions for Add Two Numbers.
     * Memory Usage: 39.2 MB, less than 80.09% of Java online submissions for Add Two Numbers.
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();

        ListNode p1 = l1;
        ListNode p2 = l2;

        int carryover = 0;
        ListNode pre = head;
        while (p1 != null || p2 != null) {
            int sum = carryover;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }

            ListNode node = new ListNode();
            node.val = sum % 10;
            carryover = sum / 10;

            pre.next = node;
            pre = pre.next;
        }

        if (carryover == 1) {
            pre.next = new ListNode(1);
        }

        return head.next;
    }

}
