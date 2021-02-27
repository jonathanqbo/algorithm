package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/20/21 8:36 PM
 */
public class Q460LFUCache {

    /**
     * solution 1: 3 HashMap + LinkedHashSet
     *
     * Runtime: 22 ms, faster than 63.70% of Java online submissions for LFU Cache.
     * Memory Usage: 53.7 MB, less than 27.02% of Java online submissions for LFU Cache.
     *
     */
    class LFUCache {
        private LFUQueue queue;
        private Map<Integer, Integer> values;
        private int capacity;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            values = new HashMap<>(capacity);
            queue = new LFUQueue(capacity);
        }

        public int get(int key) {
            Integer value = values.get(key);
            if (value == null) {
                return -1;
            }

            queue.visit(key);

            return value;
        }

        public void put(int key, int value) {
            // there is a testcase giving capacity 0
            if (capacity == 0) {
                return;
            }

            if (!values.containsKey(key)) {
                if (values.size() == capacity) {
                    int keyToRemove = queue.poll();
                    values.remove(keyToRemove);
                }

                queue.firstVisit(key);
            } else {
                queue.visit(key);
            }

            values.put(key, value);
        }

    }

    class LFUQueue {
        private Map<Integer, Integer> hits;
        private Map<Integer, LinkedHashSet<Integer>> lists;

        private int min;

        public LFUQueue(int capacity) {
            hits = new HashMap<>(capacity);
            lists = new HashMap<>();
        }

        public int poll() {
            int hit = min;
            LinkedHashSet<Integer> list = lists.get(hit);
            int key = list.iterator().next();

            if (list.size() == 1) {
                lists.remove(hit);
                // only poll when new item added, so min is always 1
                min = 1;
            } else {
                list.remove(key);
            }

            hits.remove(key);

            return key;
        }

        public void firstVisit(int key) {
            int hit = 1;
            hits.put(key, hit);

            lists.putIfAbsent(hit, new LinkedHashSet());
            lists.get(hit).add(key);

            //
            min = 1;
        }

        public void visit(int key) {
            int hit = hits.get(key);
            LinkedHashSet<Integer> list = lists.get(hit);

            hits.put(key, hit + 1);

            // remove from former list
            // 1. if it's the only one in the list, remove whole list
            if (list.size() == 1) {
                lists.remove(hit);

                // KEY: if current key is the min visited item and the only one,
                // it will be increased by 1, so min also need +1 to keep same with hit.
                if (hit == min) {
                    min = hit + 1;
                }
            }
            // 2. otherwise, remove key from list
            else {
                list.remove(key);
            }

            // add into hit+1 list
            lists.putIfAbsent(hit + 1, new LinkedHashSet<>());
            lists.get(hit + 1).add(key);
        }

    }

}


/**
 * solution 2: PriorityQueue with Insert Timestamp
 * not good solution to use PriorityQueue with insert timestamp
 *
 * Runtime: 85 ms, faster than 14.02% of Java online submissions for LFU Cache.
 * Memory Usage: 47 MB, less than 88.50% of Java online submissions for LFU Cache.
 *
 */
class LFUCache2 {
    private PriorityQueue<Node> queue;
    private Map<Integer, Node> values;
    private int capacity;
    private int ts = Integer.MIN_VALUE;

    public LFUCache2(int capacity) {
        this.capacity = capacity;
        values = new HashMap<>(capacity);
        queue = new PriorityQueue<>((n1, n2) -> n1.hit != n2.hit ? n1.hit - n2.hit : n1.ts - n2.ts);
    }

    public int get(int key) {
        Node node = values.get(key);
        if (node == null) {
            return -1;
        }

        //
        queue.remove(node);
        node.hit += 1;
        node.ts = ++ts;
        queue.offer(node);

        return node.val;
    }

    public void put(int key, int value) {
        // there is a testcase giving capacity 0
        if (capacity == 0) {
            return;
        }

        if (!values.containsKey(key)) {
            if (values.size() == capacity) {
                Node nodeToRemove = queue.poll();
                values.remove(nodeToRemove.key);
            }

            Node node = new Node(key, value, ++ts);
            queue.offer(node);
            values.put(key, node);
        } else {
            Node node = values.get(key);
            queue.remove(node);

            node.val = value;
            node.hit += 1;
            node.ts = ++ts;
            queue.offer(node);
        }
    }

    class Node {
        int key;
        int val;
        int hit;
        int ts;

        public Node(int key, int val, int ts) {
            this.key = key;
            this.val = val;
            this.hit = 1;
            this.ts = ts;
        }

    }

}
