package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/30/20 2:09 PM
 */
public class Q708InsertIntoASortedCircularLinkedList {

    /**
     * solution 1: find min/max value node, then insert like normal linkedlist
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Sorted Circular Linked List.
     * Memory Usage: 38.1 MB, less than 95.69% of Java online submissions for Insert into a Sorted Circular Linked List.
     *
     * @param head
     * @param insertVal
     * @return
     */
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);

        if (head == null) {
            node.next = node;
            return node;
        }
        if (head.next == head || head.val == insertVal) {
            node.next = head.next;
            head.next = node;
            return head;
        }

        // find smallest node (new head) and biggest node (new tail)
        Node pre = head;
        while (pre.next != head && pre.val <= pre.next.val) {
            // to save time: it could find the right place during this process.
            if (pre.val < insertVal && pre.next.val >= insertVal) {
                node.next = pre.next;
                pre.next = node;
                return head;
            }

            pre = pre.next;
        }

        // pre.next is new header with smallest value
        // pre is new tail
        Node tail = pre;

        pre = pre.next;
        while (pre != tail) {
            if (pre.val < insertVal && pre.next.val >= insertVal) {
                node.next = pre.next;
                pre.next = node;
                return head;
            }
            pre = pre.next;
        }

        // add between head and tail
        node.next = tail.next;
        tail.next = node;
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    /**
     * solution 2: handle all the scenario
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Sorted Circular Linked List.
     * Memory Usage: 38.3 MB, less than 78.30% of Java online submissions for Insert into a Sorted Circular Linked List.
     *
     * @param head
     * @param insertVal
     * @return
     */
    public Node insert2(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }

        Node prev = head;
        Node curr = head.next;
        boolean toInsert = false;

        do {
            if (prev.val <= insertVal && insertVal <= curr.val) {
                // Case 1).
                toInsert = true;
            } else if (prev.val > curr.val) {
                // Case 2).
                if (insertVal >= prev.val || insertVal <= curr.val)
                    toInsert = true;
            }

            if (toInsert) {
                prev.next = new Node(insertVal, curr);
                return head;
            }

            prev = curr;
            curr = curr.next;
        } while (prev != head);

        // Case 3).
        prev.next = new Node(insertVal, curr);
        return head;
    }

}
