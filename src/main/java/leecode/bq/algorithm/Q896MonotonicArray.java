package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:29 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q896MonotonicArray {

    class Solution {
        public boolean isMonotonic(int[] A) {
            boolean increasing = true;
            boolean decreasing = true;
            for (int i = 0; i < A.length - 1; ++i) {
                if (A[i] > A[i+1])
                    increasing = false;
                if (A[i] < A[i+1])
                    decreasing = false;
            }

            return increasing || decreasing;
        }
    }

}
