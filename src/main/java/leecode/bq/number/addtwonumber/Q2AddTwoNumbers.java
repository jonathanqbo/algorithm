package leecode.bq.number.addtwonumber;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/29/20 10:05 PM
 */
public class Q2AddTwoNumbers {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
     * Memory Usage: 39.7 MB, less than 22.12% of Java online submissions for Add Two Numbers.
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode();

        int carry = 0;
        ListNode curNode = dummyHead;
        // key: here uses OR
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            int cur = sum % 10;
            carry = sum / 10;

            curNode.next = new ListNode(cur);
            curNode = curNode.next;
        }

        if (carry != 0) {
            curNode.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

}
