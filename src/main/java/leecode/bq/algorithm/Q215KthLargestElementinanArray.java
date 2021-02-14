package leecode.bq.algorithm;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/6/21 4:21 PM
 */
public class Q215KthLargestElementinanArray {

    /**
     * solution 1: quick select
     * <p>
     * Runtime: 1 ms, faster than 97.99% of Java online submissions for Kth Largest Element in an Array.
     * Memory Usage: 39.2 MB, less than 69.26% of Java online submissions for Kth Largest Element in an Array.
     * <p>
     * Time complexity : O(N) in the average case, O(N^2) in the worst case.
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // kth largest == n-k smallest (0 based)
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[k];
        }

        int pivotIndex = new Random().nextInt(right - left) + left;
        pivotIndex = partition(nums, left, right, pivotIndex);

        if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else if (k > pivotIndex) {
            return quickSelect(nums, pivotIndex + 1, right, k);
        } else {
            return nums[pivotIndex];
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivot = nums[pivotIndex];

        // move pivot to end
        swap(nums, pivotIndex, right);

        int newPivotIndex = left;
        // any element that < pivot, move to newPivotIndex, and newPivotIndex point to next
        // newPivotIndex will never be right+1, since there is a pivot
        for (int i = left; i <= right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, newPivotIndex);
                newPivotIndex++;
            }
        }

        // move pivot to newPivotIndex
        swap(nums, right, newPivotIndex);

        return newPivotIndex;
    }

    private void swap(int[] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }


    /**
     * solution 2: Priority Queue
     *
     * Runtime: 4 ms, faster than 60.32% of Java online submissions for Kth Largest Element in an Array.
     * Memory Usage: 39 MB, less than 94.99% of Java online submissions for Kth Largest Element in an Array.
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        // note: sort pq in asending order, so pq.poll() always pop the smallest one.
        PriorityQueue<Integer> pq = new PriorityQueue<>((num1, num2) -> num1 - num2);

        for (Integer num : nums) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }

}
