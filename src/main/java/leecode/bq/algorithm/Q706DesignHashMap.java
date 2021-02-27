package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 *
 * solution: ArrayList (hash) + LinkedList (collision)
 *
 * Runtime: 18 ms, faster than 54.07% of Java online submissions for Design HashMap.
 * Memory Usage: 43.2 MB, less than 76.48% of Java online submissions for Design HashMap.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/26/21 11:04 PM
 */
public class Q706DesignHashMap {

    static final int SIZE = 2069;
    List<Bucket> buckets;

    /** Initialize your data structure here. */
    public Q706DesignHashMap() {
        buckets = new ArrayList<>(SIZE);

        for (int i = 0; i < SIZE; i++) {
            buckets.add(new Bucket());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        buckets.get(hash(key)).put(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return buckets.get(hash(key)).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        buckets.get(hash(key)).remove(key);
    }

    private int hash(int key) {
        return key % SIZE;
    }

    class Bucket {
        List<Pair> items = new LinkedList<>();

        void put(int key, int value) {
            Pair item = indexOf(key);
            if (item != null) {
                item.value = value;
            } else {
                items.add(new Pair(key, value));
            }
        }

        int get(int key) {
            Pair item = indexOf(key);
            return item == null ? -1 : item.value;
        }

        void remove(int key) {
            items.remove(indexOf(key));
        }

        Pair indexOf(int key) {
            for (Pair item: items) {
                if (item.key == key) {
                    return item;
                }
            }

            return null;
        }
    }

    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
