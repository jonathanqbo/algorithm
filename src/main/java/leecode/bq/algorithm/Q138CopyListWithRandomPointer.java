package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:54 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */

import leecode.bq.Node;

import java.util.HashMap;
import java.util.Map;

/**
 solution: recursion

 if node is not created:
 create one
 put into map
 copy next if not null
 copy random if not null

 KEY: after create new copy, immediately put it into Map to handle circular reference

 --------------

 solution 2: non-recursion

 normal idea: whenever needed, created immediately, next time just get from Map.
 loop the old list as normal, for each old node:
 create clone if not created, and put into Map
 create clone on oldnode.next if not created, and put into Map
 create clone on oldnode.random if not created, and put into Map
 newnode.next = clonedNext
 newnode.random = clonedRandom
 newnode and oldnode both move to next

 */
class Q138CopyListWithRandomPointer {

    Map<Node, Node> nodeToCopy = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (nodeToCopy.containsKey(head)) {
            return nodeToCopy.get(head);
        }

        Node copy = new Node(head.val);
        nodeToCopy.put(head, copy);

        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);

        return copy;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
