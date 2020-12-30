package leecode.bq.algorithm;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/29/20 9:50 PM
 */
public class Q234PalindromeLinkedList {

    /**
     * solution:
     * 1. find the middle
     * 2. reverse the second half
     * 3. check if it's palindrome
     * 4. reverse the second half back
     *
     * Runtime: 1 ms, faster than 95.24% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 41.3 MB, less than 91.75% of Java online submissions for Palindrome Linked List.
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse:
        // 0 -> 1 -> 2 -> 3 -> 3 -> 2 -> 1 -> 0 ==>
        // 0 -> 1 -> 2 -> 3 -> 3 <- 2 <- 1 <- 0
        ListNode tail = reverse(slow);

        // compare
        ListNode p2 = tail;
        ListNode p1 = head;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }

            p2 = p2.next;
            p1 = p1.next;
        }

        // reverse list back
        reverse(tail);

        return true;
    }

    private ListNode reverse(ListNode head) {
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

}
