package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/30/20 5:05 PM
 */
public class Q977SquaresOfASortedArray {

    /**
     * solution: 2 pointers from start and end.
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Squares of a Sorted Array.
     * Memory Usage: 41 MB, less than 56.78% of Java online submissions for Squares of a Sorted Array.
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        if (nums == null) {
            return nums;
        }

        int[] result = new int[nums.length];

        int start = 0;
        int end = nums.length - 1;
        int i = end;
        while (start <= end) {
            int v1 = nums[start] * nums[start];
            int v2 = nums[end] * nums[end];
            if (v1 > v2) {
                start++;
                result[i] = v1;
            } else {
                end--;
                result[i] = v2;
            }

            i--;
        }

        return result;
    }

}
