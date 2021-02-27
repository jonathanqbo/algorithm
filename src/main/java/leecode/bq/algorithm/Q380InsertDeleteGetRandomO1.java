package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/21/21 5:58 PM
 */
public class Q380InsertDeleteGetRandomO1 {

    /**
     * solution: Map<Value, Index> + ArrayList<Value>
     *
     * Runtime: 9 ms, faster than 56.57% of Java online submissions for Insert Delete GetRandom O(1).
     * Memory Usage: 43.6 MB, less than 86.56% of Java online submissions for Insert Delete GetRandom O(1).
     *
     */
    class RandomizedSet {

        Map<Integer, Integer> valToIdx = new HashMap<>();
        List<Integer> vals = new ArrayList<>();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {

        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (valToIdx.containsKey(val)) {
                return false;
            }

            vals.add(val);
            valToIdx.put(val, vals.size() - 1);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!valToIdx.containsKey(val)) {
                return false;
            }

            int idx = valToIdx.get(val);
            // KEY: to achieve O(1) delete for array list, put last item to idx, and remove last item
            int valLastElement = vals.get(vals.size() - 1);
            vals.set(idx, valLastElement);
            vals.remove(vals.size() - 1);
            valToIdx.put(valLastElement, idx);
            valToIdx.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int idx = new Random().nextInt(vals.size());
            return vals.get(idx);
        }
    }


    /**
     * solution 2: two Map: Map<Index, Value> + Map<Value, Index>
     * pretty same with solution1
     *
     * Runtime: 11 ms, faster than 41.17% of Java online submissions for Insert Delete GetRandom O(1).
     * Memory Usage: 43.4 MB, less than 93.94% of Java online submissions for Insert Delete GetRandom O(1).
     *
     */
    class RandomizedSet2 {

        Map<Integer, Integer> valToIdx = new HashMap<>();
        Map<Integer, Integer> idxToVal = new HashMap<>();
        int size = 0;

        /** Initialize your data structure here. */
        public RandomizedSet2() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (valToIdx.containsKey(val)) {
                return false;
            }

            valToIdx.put(val, size);
            idxToVal.put(size, val);

            size++;

            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!valToIdx.containsKey(val)) {
                return false;
            }

            int idx = valToIdx.get(val);
            valToIdx.remove(val);
            if (idx != size - 1) {
                int lastVal = idxToVal.get(size - 1);
                // put the last element to the deleted element
                valToIdx.put(lastVal, idx);
                idxToVal.put(idx, lastVal);

                // remove last element
                idxToVal.remove(size - 1);
            } else {
                idxToVal.remove(size - 1);
            }

            size--;

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int idx = new Random().nextInt(size);

            return idxToVal.get(idx);
        }
    }

}
