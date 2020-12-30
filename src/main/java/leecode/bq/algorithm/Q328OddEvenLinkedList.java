package leecode.bq.algorithm;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/29/20 8:38 PM
 */
public class Q328OddEvenLinkedList {

    /**
     * solution: two list: odd/even, and keep each head and tail
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Odd Even Linked List.
     * Memory Usage: 38.4 MB, less than 89.18% of Java online submissions for Odd Even Linked List.
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = head;
        ListNode evenHead = head.next;

        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;

        ListNode cur = head.next.next;
        while (evenTail != null && evenTail.next != null) {
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;

            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }

        oddTail.next = evenHead;

        return head;
    }

}
