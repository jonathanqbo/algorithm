package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 3/28/21 9:43 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q829ConsecutiveNumbersSum {

    /**
     * solution: math
     *
     * let N = k + (k+1) + (k+2) + (k+3) + ... + (k+i-1) = i*k + (1+2+3+... + i-1)
     * let sum(i) = (1+2+3+...+i-1), then we have
     * N = sum(i) + i*k ==>i*k = N - sum(i)
     * Which means: for each i, we can calculate N-sum(i). If N-sum(i) can be divided by i, there is an answer with length i.
     * Because, let k = (N - sum(i)) / i, we can add an integer k to each of (0,1, 2, 3, 4, ...., i-1) to become (k, k+1, k+2, k+3,.... k + i-1)
     * that is: sum(i) + i * k = N
     */
    class Solution {
        public int consecutiveNumbersSum(int N) {
            int result = 0;
            int sum = 0;
            // NOTE: end condition: sum < N
            for (int i = 1; sum < N; i++) {
                sum += i;
                if ((N - sum) % i == 0) {
                    result++;
                }
            }

            return result;
        }
    }

}
