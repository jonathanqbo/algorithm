package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/22/20 10:21 PM
 */
public class Q26RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return nums.length;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }

    public static void main(String[] args) {
        new Q26RemoveDuplicatesFromSortedArray().removeDuplicates(new int[]{1, 1, 2});
    }

}
