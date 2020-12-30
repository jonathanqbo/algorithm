package leecode.bq.algorithm;

import leecode.bq.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/29/20 3:03 PM
 */
public class Q160IntersectionOfTwoLinkedLists {

    /**
     * solution 1: hash set
     *
     * Runtime: 7 ms, faster than 26.28% of Java online submissions for Intersection of Two Linked Lists.
     * Memory Usage: 43.1 MB, less than 13.17% of Java online submissions for Intersection of Two Linked Lists.
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> nodesA = new HashSet();
        ListNode node = headA;
        while (node != null) {
            nodesA.add(node);

            node = node.next;
        }

        node = headB;
        while (node != null) {
            if (nodesA.contains(node)) {
                return node;
            }

            node = node.next;
        }

        return null;
    }

    /**
     * solution 2: two pointers loop through listA/B then list B/A, if join, then they must meet in the join node
     *
     * Runtime: 1 ms, faster than 97.79% of Java online submissions for Intersection of Two Linked Lists.
     * Memory Usage: 41.7 MB, less than 71.23% of Java online submissions for Intersection of Two Linked Lists.
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        ListNode t1 = null;
        ListNode t2 = null;
        while (p1 != p2) {
            if (p1.next == null) {
                t1 = p1;
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if (p2.next == null) {
                t2 = p2;
                p2 = headA;
            } else {
                p2 = p2.next;
            }

            if (t1 != null && t2 != null && t1 != t2) {
                return null;
            }
        }

        return p1;
    }

}
