package leecode.bq.algorithm;

import leecode.bq.ListNode;

import java.util.PriorityQueue;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/3/21 9:15 PM
 */
public class Q23MergekSortedLists {

    /**
     * solution: compare haeder one-by-one
     *
     * Runtime: 312 ms, faster than 5.07% of Java online submissions for Merge k Sorted Lists.
     * Memory Usage: 44.1 MB, less than 10.03% of Java online submissions for Merge k Sorted Lists.
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();

        ListNode last = head;
        while (true) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode headi = lists[i];
                if (headi != null) {
                    if (headi.val < min) {
                        min = headi.val;
                        minIndex = i;
                    }
                }
            }

            if (minIndex == -1) {
                break;
            }

            last.next = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            last = last.next;
        }

        return head.next;
    }


    /**
     * solution 2: optimized solution 1 by PriorityQueue
     *
     * Runtime: 8 ms, faster than 26.57% of Java online submissions for Merge k Sorted Lists.
     * Memory Usage: 44.3 MB, less than 7.87% of Java online submissions for Merge k Sorted Lists.
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode head = new ListNode();

        ListNode last = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n1.val, n2.val);
        });

        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) {
                pq.offer(node.next);
            }

            last.next = node;
            last = last.next;
        }

        return head.next;
    }

    /**
     * solution 3: merge list one by one
     *
     * Runtime: 121 ms, faster than 13.10% of Java online submissions for Merge k Sorted Lists.
     * Memory Usage: 44.3 MB, less than 7.87% of Java online submissions for Merge k Sorted Lists.
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists3(ListNode[] lists) {
        ListNode result = null;
        for (ListNode list: lists) {
            result = merge2Lists(result, list);
        }

        return result;
    }

    private ListNode merge2Lists(ListNode head1, ListNode head2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }

            tail = tail.next;
        }

        if (head1 != null) {
            tail.next = head1;
        }
        if (head2 != null) {
            tail.next = head2;
        }

        return head.next;
    }

    /**
     * solution 4: improve solution 3 by divided & conquer
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Merge k Sorted Lists.
     * Memory Usage: 41.1 MB, less than 21.05% of Java online submissions for Merge k Sorted Lists
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists4(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return reduce(lists, 0, lists.length - 1);
    }

    private ListNode reduce(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode list1 = reduce(lists, start, mid);
        ListNode list2 = reduce(lists, mid + 1, end);

        return merge2Lists(list1, list2);
    }

    /**
     * solution 5: non-recursion version of solution 4
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists5(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        int k = lists.length;
        while (k > 1) {
            if (k % 2 == 1) {
                lists[0] = merge2Lists(lists[0], lists[k - 1]);
            }
            // note: i + 1 < k
            int w = 0;
            for (int i = 0; i + 1 < k; i += 2) {
                lists[w++] = merge2Lists(lists[i], lists[i + 1]);
            }

            k = k / 2;
        }

        return lists[0];
    }
}
