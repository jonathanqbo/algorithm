package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/11/21 11:01 PM
 */
public class Q189RotateArray {

    /**
     * solution 1: brute force
     *
     * Runtime: 213 ms, faster than 9.91% of Java online submissions for Rotate Array.
     * Memory Usage: 39.6 MB, less than 55.76% of Java online submissions for Rotate Array.
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        for (int i = 0; i < k; i++) {
            // key:
            int pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int tmp = nums[j];
                nums[j] = pre;
                pre = tmp;
            }
        }
    }

    /**
     * solution 2: extra array
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
     * Memory Usage: 39.9 MB, less than 16.33% of Java online submissions for Rotate Array.
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;

        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // key
            tmp[(i + k) % nums.length] = nums[i];
        }

        System.arraycopy(tmp, 0, nums, 0, nums.length);
    }

    /**
     * solution 3: three reverse
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
     * Memory Usage: 39.9 MB, less than 16.33% of Java online submissions for Rotate Array.
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;

            start++;
            end--;
        }
    }

    /**
     * solution 4: cyclic replacement
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Array.
     * Memory Usage: 39.9 MB, less than 16.33% of Java online submissions for Rotate Array.
     *
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        k %= nums.length;

        int start = 0;
        int count = 0;

        // key: stop condition: count == nums.length
        while (count < nums.length) {
            int current = start;
            int pre = nums[start];
            do {
                current = (current + k) % nums.length;
                int tmp = nums[current];
                nums[current] = pre;
                pre = tmp;

                count++;
            } while (start != current); // one loop

            start++;
        }
    }
}
