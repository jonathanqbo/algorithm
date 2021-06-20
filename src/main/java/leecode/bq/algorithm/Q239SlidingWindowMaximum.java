package leecode.bq.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:59 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q239SlidingWindowMaximum {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (k == 0 || nums.length == 0) {
                return new int[0];
            }
            if (k == 1) {
                return nums;
            }

            int n = nums.length;
            k = n < k ? n : k;

            // left <-> right
            int[] left = new int[n];
            left[0] = nums[0];
            int[] right = new int[n];
            right[n - 1] = nums[n - 1];
            for (int i = 1; i < n; i++) {
                if (i % k == 0) {
                    left[i] = nums[i];
                } else {
                    left[i] = nums[i] > left[i - 1] ? nums[i] : left[i - 1];
                }

                int j = n - i - 1;
                // Trick: to get the first one from right
                if ((j + 1) % k == 0) {
                    right[j] = nums[j];
                } else {
                    right[j] = nums[j] > right[j + 1] ? nums[j] : right[j + 1];
                }
            }

            int[] result = new int[n - k + 1];
            for (int i = 0; i < n - k + 1; i++) {
                // KEY: maxOfWindow(i, j) = max(right[i], left[j])
                result[i] = Math.max(right[i], left[i + k - 1]);
            }

            return result;
        }

    }

    class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (k == 0 || nums.length == 0) {
                return new int[0];
            }
            if (k == 1) {
                return nums;
            }

            k = nums.length < k ? nums.length : k;
            int[] result = new int[nums.length - k + 1];

            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < k; i++) {
                addToQueue(deque, nums, i, k);
            }
            result[0] = nums[deque.peekFirst()];

            for (int i = k; i < nums.length; i++) {
                addToQueue(deque, nums, i, k);
                result[i - k + 1] = nums[deque.peekFirst()];
            }

            return result;
        }

        private void addToQueue(Deque<Integer> deque, int[] nums, int idx, int k) {
            if (deque.isEmpty()) {
                deque.offerLast(idx);
                return;
            }

            // key: keep index in deque, so can know which idx to remove
            if (deque.peekFirst()  <= idx - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[idx]) {
                deque.pollLast();
            }

            deque.offerLast(idx);
        }
    }

}