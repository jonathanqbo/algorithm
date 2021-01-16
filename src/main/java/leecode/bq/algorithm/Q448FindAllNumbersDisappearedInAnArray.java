package leecode.bq.algorithm;

import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/1/21 12:44 AM
 */
public class Q448FindAllNumbersDisappearedInAnArray {

    /**
     * solution: trick
     *
     * o(1) space
     *
     * Runtime: 5 ms, faster than 81.53% of Java online submissions for Find All Numbers Disappeared in an Array.
     * Memory Usage: 47.4 MB, less than 93.73% of Java online submissions for Find All Numbers Disappeared in an Array.
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]) - 1;
            if (nums[j] > 0)
                nums[j] = -nums[j];
        }

        List<Integer> result = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                result.add(i + 1);
        }

        return result;
    }

    /**
     * solution 2: use extra array to mark existed values
     *
     * O(n)
     *
     * Runtime: 3 ms, faster than 100.00% of Java online submissions for Find All Numbers Disappeared in an Array.
     * Memory Usage: 48.5 MB, less than 16.61% of Java online submissions for Find All Numbers Disappeared in an Array.
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int[] numsMark = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numsMark[nums[i] - 1] = 1;
        }

        List<Integer> result = new LinkedList();
        for (int i = 0; i < numsMark.length; i++) {
            if (numsMark[i] == 0)
                result.add(i + 1);
        }

        return result;
    }

}
