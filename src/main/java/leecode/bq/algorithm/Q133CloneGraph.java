package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:52 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q133CloneGraph {

    /**

     solution 1: reccursion (simple)

     solution 2: non-recursion by bfs

     *** graph bfs traversal code template ***

     */
    class Solution {

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }

            Map<Node, Node> nodeToClone = new HashMap<>();

            Set<Node> visited = new HashSet<>();
            Node cloneNode = new Node(node.val);
            nodeToClone.put(node, cloneNode);

            Queue<Node> queue = new LinkedList<>();
            queue.offer(node);
            visited.add(node);

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                Node clone = nodeToClone.get(cur);

                for (Node neighbor : cur.neighbors) {
                    nodeToClone.putIfAbsent(neighbor, new Node(neighbor.val));
                    clone.neighbors.add(nodeToClone.get(neighbor));

                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }

            return cloneNode;
        }

    }

    /**


     */
    class Solution1 {

        Map<Node, Node> nodeToNode = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }

            if (nodeToNode.containsKey(node)) {
                return nodeToNode.get(node);
            }

            Node newNode = new Node(node.val);
            nodeToNode.put(node, newNode);

            for (Node neighbor : node.neighbors) {
                newNode.neighbors.add(cloneGraph(neighbor));
            }

            return newNode;
        }

    }


    /**

     solution: bfs (note: this is a bidirection graph, remember to check if node visited)

     key: bfs on old Tree instead of cloned tree.

     */
    class Solution2 {

        Map<Node, Node> nodeToNode = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }

            Node newNode = new Node(node.val);
            nodeToNode.put(node, newNode);

            // bfs
            Queue<Node> queue = new LinkedList<>();
            queue.offer(node);

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                Node newCur = nodeToNode.get(cur);

                for (Node neighbor: cur.neighbors) {
                    if (!nodeToNode.containsKey(neighbor)) {
                        nodeToNode.put(neighbor, new Node(neighbor.val));
                        queue.offer(neighbor);
                    }

                    // key: no matter the node visited or not, always need to add as neighbor
                    newCur.neighbors.add(nodeToNode.get(neighbor));
                }
            }

            return newNode;
        }

    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
