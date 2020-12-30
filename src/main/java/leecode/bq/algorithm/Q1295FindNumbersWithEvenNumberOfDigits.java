package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/30/20 4:36 PM
 */
public class Q1295FindNumbersWithEvenNumberOfDigits {

    /**
     * Runtime: 1 ms, faster than 94.36% of Java online submissions for Find Numbers with Even Number of Digits.
     * Memory Usage: 38.2 MB, less than 99.10% of Java online submissions for Find Numbers with Even Number of Digits.
     *
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {
        int amount = 0;
        for (int i = 0;i < nums.length; i++) {
            if (hasEvenNumberDigits(nums[i]))
                amount++ ;
        }

        return amount;
    }

    private boolean hasEvenNumberDigits(int num) {
        int digits = 1;

        while (num / 10 != 0) {
            digits++;
            num = num / 10;
        }

        return digits % 2 == 0;
    }

}
