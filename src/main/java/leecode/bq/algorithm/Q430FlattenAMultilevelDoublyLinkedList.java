package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/29/20 11:02 PM
 */
public class Q430FlattenAMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        flattenChild(head);
        return head;
    }

    /**
     * return last node
     */
    private Node flattenChild(Node head) {
        System.out.println(head.val);
        Node node = head;
        Node pre = null;
        while (node != null) {
            if (node.child != null) {
                Node subtail = flattenChild(node.child);
                System.out.println("sublist tail:" + subtail.val);

                if (node.next != null) {
                    node.next.prev = subtail;
                }

                subtail.next = node.next;
                node.next = node.child;
                node.child.prev = node;

                node.child = null;

                pre = subtail;
                node = subtail.next;
            } else {
                pre = node;
                node = node.next;
            }
        }

        return pre;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

}
