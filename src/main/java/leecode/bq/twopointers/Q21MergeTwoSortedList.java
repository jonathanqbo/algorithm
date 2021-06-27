package leecode.bq.twopointers;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/22/20 9:51 PM
 */
public class Q21MergeTwoSortedList {

    /**

     solution: normal two pointer for each List

     while list1 AND list2 not null, then handle the left part of list1 OR list2

     */
    class Solution {

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();

            ListNode cur = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }

                cur = cur.next;
            }

            if (l1 != null) {
                cur.next = l1;
            }
            if (l2 != null) {
                cur.next = l2;
            }

            return dummy.next;
        }

    }

}
