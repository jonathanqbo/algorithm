package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/6/21 10:05 PM
 */
public class Q167TwoSumIIInputArrayIsSorted {

    /**
     * solution: mix binary search and two pointer
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum II - Input array is sorted.
     * Memory Usage: 39.2 MB, less than 64.79% of Java online submissions for Two Sum II - Input array is sorted.
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // key: check sum of left and right
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum > target) {
                right = (numbers[mid] + numbers[left] > target) ? mid - 1: right - 1;
            } else {
                left = (numbers[right] + numbers[mid] < target) ? mid + 1 : left + 1;
            }
        }

        // not found
        return new int[] {-1, -1};
    }

}
