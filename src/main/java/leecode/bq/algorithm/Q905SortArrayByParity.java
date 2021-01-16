package leecode.bq.algorithm;

import java.util.Arrays;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/31/20 5:09 PM
 */
public class Q905SortArrayByParity {

    /**
     * solution 1: in-place
     *
     * Runtime: 1 ms, faster than 98.58% of Java online submissions for Sort Array By Parity.
     * Memory Usage: 40 MB, less than 44.60% of Java online submissions for Sort Array By Parity.
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int odd = 0;
        int even = A.length - 1;

        while (odd < even) {
            if (A[odd] % 2 == 1 && A[even] % 2 == 0) {
                int tmp = A[odd];
                A[odd] = A[even];
                A[even] = tmp;
            }

            if (A[odd] % 2 != 1) {
                odd++;
            }

            if (A[even] % 2 != 0) {
                even--;
            }
        }

        return A;
    }

    /**
     * solution 2: new array
     *
     * Runtime: 1 ms, faster than 98.58% of Java online submissions for Sort Array By Parity.
     * Memory Usage: 39.4 MB, less than 98.90% of Java online submissions for Sort Array By Parity.
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity2(int[] A) {
        int[] B = new int[A.length];

        int start = 0;
        int end = B.length - 1;

        for (int v : A) {
            if (v % 2 == 0) {
                B[start] = v;
                start++;
            } else {
                B[end] = v;
                end--;
            }
        }

        return B;
    }

}
