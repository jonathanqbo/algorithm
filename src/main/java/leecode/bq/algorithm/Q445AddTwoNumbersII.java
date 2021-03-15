package leecode.bq.algorithm;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/12/21 6:06 PM
 */
public class Q445AddTwoNumbersII {

    /**
     * solution 1: revert + normal addition
     *
     * Runtime: 2 ms, faster than 98.70% of Java online submissions for Add Two Numbers II.
     * Memory Usage: 38.9 MB, less than 95.81% of Java online submissions for Add Two Numbers II.
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = revert(l1);
            l2 = revert(l2);

            ListNode head = new ListNode();
            ListNode node = head;
            int carryOver = 0;
            while (l1 != null || l2 != null) {
                int d1 = l1 == null ? 0 : l1.val;
                int d2 = l2 == null ? 0 : l2.val;
                int sum = d1 + d2 + carryOver;

                carryOver = sum / 10;
                int val = sum % 10;
                node.next = new ListNode(val);
                node = node.next;

                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }

            //
            if (carryOver > 0) {
                node.next = new ListNode(carryOver);
            }

            return revert(head.next);
        }

        private ListNode revert(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode tmp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = tmp;
            }

            // KEY: pre points to last
            return pre;
        }
    }

}
