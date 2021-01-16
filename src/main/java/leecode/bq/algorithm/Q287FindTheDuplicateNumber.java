package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/6/21 11:02 PM
 */
public class Q287FindTheDuplicateNumber {

    /**
     * solution 1: keep putting number to their right postion until find the value is already existed
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Duplicate Number.
     * Memory Usage: 38.8 MB, less than 86.54% of Java online submissions for Find the Duplicate Number.
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int right = nums.length - 1;
        while (nums[right] != nums[nums[right] - 1]) {
            int tmp = nums[right];
            nums[right] = nums[tmp - 1];
            nums[tmp - 1] = tmp;
        }

        return nums[right];
    }

    /**
     * solution 2: Floyd algorithm
     *
     * key: how to simulate cycle as linkedlist.
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find the Duplicate Number.
     * Memory Usage: 39.2 MB, less than 45.04% of Java online submissions for Find the Duplicate Number.
     *
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int i = nums[0];
        while (i != slow) {
            i = nums[i];
            slow = nums[slow];
        }

        return i;
    }

}
