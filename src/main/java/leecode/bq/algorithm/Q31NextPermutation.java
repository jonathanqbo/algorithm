package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/25/21 9:19 PM
 */
public class Q31NextPermutation {

    /**
     * solution:
     * 1: find the first number that nums[i] < nums[i + 1] from end
     * 2: find the first number that nums[j] > nums[i] from end
     * 3: swap nums[i] with nums[j]
     * 4: reverse nums[i+1] to end
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Next Permutation.
     * Memory Usage: 39.2 MB, less than 48.56% of Java online submissions for Next Permutation.
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // key: note here is <=
        while (i >= 0 && nums[i] >= nums[i + 1] ) {
            i--;
        }

        if (i < 0) {
            // here don't need to sort, just need to reverse
            // Arrays.sort(nums);
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // find the last j in the right side of i that nums[j] > nums[i]
        int j = i;
        while (j < nums.length - 1 && nums[j + 1] > nums[i]) {
            j++;
        }

        // swap i and j
        swap(nums, i, j);

        // reverse i+1 to end
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

}
