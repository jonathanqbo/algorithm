package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/5/21 12:03 AM
 */
public class Q367ValidPerfectSquare {

    /**
     * solution: binary search
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Perfect Square.
     * Memory Usage: 35.7 MB, less than 55.60% of Java online submissions for Valid Perfect Square.
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;

        long left = 2, right = num / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long value = mid * mid; // use long to avoid overflow
            if (value == num) {
                return true;
            } else if (value > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

}
