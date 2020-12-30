package leecode.bq.algorithm;

import leecode.bq.ListNode;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/22/20 9:51 PM
 */
public class Q21MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header = new ListNode();
        ListNode index3 = header;
        ListNode index1 = l1;
        ListNode index2 = l2;
        while (index1 != null && index2 != null) {
            if (index1.val < index2.val) {
                index3.next = index1;
                index3 = index3.next;

                index1 = index1.next;
            } else {
                index3.next = index2;
                index3 = index3.next;

                index2 = index2.next;
            }
        }

        if (index1 != null)
            index3.next = index1;
        else if (index2 != null)
            index3.next = index2;

        return header.next;
    }
}
