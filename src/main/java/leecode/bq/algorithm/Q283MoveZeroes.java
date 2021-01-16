package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/31/20 11:28 AM
 */
public class Q283MoveZeroes {

    /**
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
     * Memory Usage: 39.2 MB, less than 64.49% of Java online submissions for Move Zeroes.
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int writeIndex = 0;
        int readIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }

        for (int i = writeIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * solution 2: swap
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[writeIndex];
                nums[writeIndex] = nums[i];
                // nums[writeIndex] could be or be none 0;
                nums[i] = tmp;
                writeIndex++;
            }
        }

        // for (int i = writeIndex; i < nums.length; i++) {
        //     nums[i] = 0;
        // }
    }
}
