package leecode.bq.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/12/21 9:34 PM
 */
public class Q136SingleNumber {

    /**
     * solution 1: hashset
     *
     * Runtime: 7 ms, faster than 45.80% of Java online submissions for Single Number.
     * Memory Usage: 39.4 MB, less than 42.94% of Java online submissions for Single Number.
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet(nums.length);

        for (int num: nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        return set.iterator().next();
    }


    /**
     * solution 2: math: 2∗(a+b+c)−(a+a+b+b+c)=c
     *
     * Runtime: 5 ms, faster than 55.60% of Java online submissions for Single Number.
     * Memory Usage: 39 MB, less than 87.87% of Java online submissions for Single Number.
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet(nums.length);

        long sum = 0;
        long setSum = 0;
        for (int num: nums) {
            if (!set.contains(num)) {
                set.add(num);
                setSum += num;
            }

            sum += num;
        }

        return (int)(2 * setSum - sum);
    }

    /**
     * solution 3: bit manipulation
     *
     * If we take XOR of zero and some bit, it will return that bit
     *     a ^ 0 = a
     * If we take XOR of two same bits, it will return 0
     *     a ^ a = 0
     *
     * a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
     *
     *
     * Runtime: 1 ms, faster than 95.81% of Java online submissions for Single Number.
     * Memory Usage: 39.3 MB, less than 60.79% of Java online submissions for Single Number.
     *
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums) {
        int result = 0;
        for (int num: nums) {
            result ^= num;
        }

        return result;
    }

}
