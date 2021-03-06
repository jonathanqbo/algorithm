package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/4/21 9:25 PM
 */
public class Q347TopKFrequentElements {

    /**
     * solution 1: Map + PriorityQueue
     *
     *Runtime: 11 ms, faster than 49.71% of Java online submissions for Top K Frequent Elements.
     * Memory Usage: 41.6 MB, less than 70.63% of Java online submissions for Top K Frequent Elements.
     *
     */
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> numCount = new HashMap<>();
            for (int num: nums) {
                numCount.put(num, numCount.getOrDefault(num, 0) + 1);
            }

            // KEY: comparator directly getting value from map
            Queue<Integer> pq = new PriorityQueue<>(
                    (num1, num2) -> numCount.get(num1) - numCount.get(num2));
            for (int num: numCount.keySet()) {
                pq.offer(num);
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = pq.poll();
            }

            return result;
        }
    }

    /**
     * solution 2: Quick Select
     */
    class Solution2 {

        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> numCount = new HashMap<>();
            for (int num : nums) {
                numCount.put(num, numCount.getOrDefault(num, 0) + 1);
            }

            int n = numCount.size();
            int[] keys = new int[n];
            int i = 0;
            for (int key : numCount.keySet()) {
                keys[i++] = key;
            }

            quickSelect(keys, numCount, 0, n - 1, n - k);

            return Arrays.copyOfRange(keys, n - k, n);
        }

        private void quickSelect(int[] arr, Map<Integer, Integer> numCount, int from, int to, int targetIdx) {
            if (from == to) {
                return;
            }

            int pivotIndex = from + new Random().nextInt(to - from);
            // new index after partition
            pivotIndex = partition(arr, numCount, from, to, pivotIndex);

            if (pivotIndex == targetIdx) {
                return;
            } else if (pivotIndex < targetIdx) {
                quickSelect(arr, numCount, pivotIndex + 1, to, targetIdx);
            } else {
                quickSelect(arr, numCount, from, pivotIndex - 1, targetIdx);
            }
        }

        private int partition(int[] arr, Map<Integer, Integer> numCount, int from, int to, int pivot) {
            int pivotValue = numCount.get(arr[pivot]);

            // move pivot to end
            swap(arr, pivot, to);

            // move all elements with less value to left
            int left = from;
            for (int i = from; i < to; i++) {
                if (numCount.get(arr[i]) < pivotValue) {
                    swap(arr, left++, i);
                }
            }

            // move pivot to its final place
            swap(arr, left, to);

            // left is the final partition index
            return left;
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

}
