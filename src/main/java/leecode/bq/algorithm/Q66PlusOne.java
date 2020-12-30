package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
 * Memory Usage: 37.2 MB, less than 96.77% of Java online submissions for Plus One.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/24/20 9:11 PM
 */
public class Q66PlusOne {

    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length];
        boolean plusOne = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (plusOne) {
                if (digit + 1 < 10) {
                    result[i] = digit + 1;
                    plusOne = false;
                } else {
                    result[i] = 0;
                }
            } else {
                result[i] = digit;
            }

        }

        if (!plusOne)
            return result;

        int[] newResult = new int[result.length + 1];
        newResult[0] = 1;
        for (int i = 0; i < result.length; i++) {
            newResult[i + 1] = result[i];
        }
        return newResult;
    }

}
