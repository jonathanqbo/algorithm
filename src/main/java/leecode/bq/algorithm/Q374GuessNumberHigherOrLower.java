package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/1/21 11:51 AM
 */
public class Q374GuessNumberHigherOrLower {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Guess Number Higher or Lower.
     * Memory Usage: 35.8 MB, less than 52.40% of Java online submissions for Guess Number Higher or Lower.
     *
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int checkResult = guess(mid);
            if (checkResult == 0) {
                return mid;
            } else if (checkResult == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    // this function is provided
    private int guess(int n) {
        return 0;
    }

}
