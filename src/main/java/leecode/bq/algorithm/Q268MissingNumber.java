package leecode.bq.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/20/21 9:16 PM
 */
public class Q268MissingNumber {

    /**
     * Runtime: 5 ms, faster than 26.17% of Java online submissions for Missing Number.
     * Memory Usage: 39.7 MB, less than 35.53% of Java online submissions for Missing Number.
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet();
        for (int num: nums) {
            numSet.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!numSet.contains(i)) {
                return i;
            }
        }

        throw new IllegalArgumentException();
    }

    /**
     * solution 2: 0-n xor nums[0... n-1]
     *
     * key: 0-n will be xor out by nums, the left is the answer
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Number.
     * Memory Usage: 39.4 MB, less than 69.40% of Java online submissions for Missing Number.
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        // 0-n xor all nums[0.. n-1], the left is the answer
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            n ^= i ^ nums[i];
        }

        return n;
    }

    /**
     * solution 3: Gauss' Formular
     *
     * key: 1 + 2 + 3 +... + n  == n * (n + 1) / 2
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Number.
     * Memory Usage: 39.5 MB, less than 45.50% of Java online submissions for Missing Number.
     *
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int n = nums.length;

        // Gauss' Formula
        int sumN = n * (n + 1) / 2;

        int sumNum = 0;
        for (int num: nums) {
            sumNum += num;
        }

        return sumN - sumNum;
    }

}
