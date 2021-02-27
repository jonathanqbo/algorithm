package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/19/21 8:58 PM
 */
public class Q146LRUCache {

    /**
     * solution 1: extends LinkedHashMap
     *
     * Runtime: 12 ms, faster than 97.93% of Java online submissions for LRU Cache.
     * Memory Usage: 47.6 MB, less than 33.14% of Java online submissions for LRU Cache.
     */
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        int capacity;

        public LRUCache(int capacity) {
            // here: true means access-order: LRU
            // false means insert-order
            super(capacity, 1.0f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
            return size() > this.capacity;
        }
    }


    /**
     * solution 3: use LinkedHashMap without extend it
     *
     * Runtime: 15 ms, faster than 43.73% of Java online submissions for LRU Cache.
     * Memory Usage: 47.3 MB, less than 56.24% of Java online submissions for LRU Cache.
     *
     */
    class LRUCache3 {
        Map<Integer, Integer> cache;
        int capacity;

        public LRUCache3(int capacity) {
            cache = new LinkedHashMap(capacity, 1.0f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return cache.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            Integer existedValue = cache.get(key);
            if (!cache.containsKey(key) && cache.size() == capacity) {
                Integer first = cache.keySet().iterator().next();
                cache.remove(first);
            }

            cache.put(key, value);
        }

    }

    /**
     * solution 5: use HashMap and LinkedHashSet (X)
     *
     * 34 ms
     *
     */
    class LRUCache5 {
        Set<Integer> queue;
        Map<Integer, Integer> cache;
        int capacity;

        public LRUCache5(int capacity) {
            cache = new HashMap(capacity);
            queue = new LinkedHashSet();
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer existedValue = cache.get(key);
            if (existedValue != null) {
                queue.remove(key);
                queue.add(key);

                return existedValue;
            }

            return -1;
        }

        public void put(int key, int value) {
            Integer existedValue = cache.get(key);
            if (existedValue == null) {
                if (cache.size() == capacity) {
                    // key: use iterator() to get earliest value
                    Integer first = queue.iterator().next();
                    queue.remove(first);
                    cache.remove(first);
                }

                cache.put(key, value);
                queue.add(key);
            } else {
                // move to latest
                queue.remove(key);
                queue.add(key);

                cache.put(key, value);
            }
        }

    }


    /**
     * solution 2: DoubleLinkedList with Node that can be delete in O(1)
     *
     * Runtime: 13 ms, faster than 81.81% of Java online submissions for LRU Cache.
     * Memory Usage: 47.3 MB, less than 56.24% of Java online submissions for LRU Cache.
     *
     */
    class LRUCache2 {
        Map<Integer, DoubleLinkedListNode<Integer, Integer>> map;
        DoubleLinkedList<Integer, Integer> list;
        int capacity;

        public LRUCache2(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity);
            list = new DoubleLinkedList<>();
        }

        public int get(int key) {
            DoubleLinkedListNode<Integer, Integer> node = map.get(key);
            if (node == null) {
                return -1;
            }

            list.moveToFirst(node);
            return node.val;
        }

        public void put(int key, int value) {
            DoubleLinkedListNode<Integer, Integer> node = map.get(key);
            if (node == null) {
                if (map.size() == capacity) {
                    DoubleLinkedListNode<Integer, Integer> lastNode = list.removeLast();
                    // Note: get Key from DoubleLinkedListNode, so node needs to keep Key and Value
                    map.remove(lastNode.key);
                }

                node = new DoubleLinkedListNode<Integer, Integer>(key, value);
                map.put(key, node);
                list.addFirst(node);
            } else {
                node.val = value;
                list.moveToFirst(node);
            }
        }

    }

    class DoubleLinkedList<K, T> {
        DoubleLinkedListNode<K, T> head = new DoubleLinkedListNode();
        DoubleLinkedListNode<K, T> tail = new DoubleLinkedListNode();

        public DoubleLinkedList() {
            head.next = tail;
            tail.pre = head;
        }

        public void moveToFirst(DoubleLinkedListNode<K, T> node) {
            remove(node);
            addFirst(node);
        }

        public void remove(DoubleLinkedListNode<K, T> node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void addFirst(DoubleLinkedListNode<K, T> node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        public DoubleLinkedListNode<K, T> removeLast() {
            DoubleLinkedListNode<K, T> node = tail.pre;
            remove(node);

            return node;
        }

    }

    class DoubleLinkedListNode<K, T> {
        K key;
        T val;
        DoubleLinkedListNode<K, T> pre;
        DoubleLinkedListNode<K, T> next;

        public DoubleLinkedListNode() {

        }

        public DoubleLinkedListNode(K key, T value) {
            this.key = key;
            this.val = value;
        }

        public String toString(){
            return String.valueOf(val);

        }
    }

}
