package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/20/21 10:41 AM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q1539KthMissingPositiveNumber {

    /**

     solution: Binary Search

     1, 2, 4, 6, 10
     ---------------
     1, 2, 3, 4, 5
     ---------------
     0, 0, 1, 2, 5

     ===> k = 4 ===> insert position = [2, 5] ==> 4 + 4 (idx + k)


     */

    class Solution {

        public int findKthPositive(int[] arr, int k) {
            // KEY: left is the first one that the diff >= k
            int left = 0;
            int right = arr.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int diff = arr[mid] - mid - 1;

                if (diff < k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // KEY: (left - 1) + 1 + k
            return left + k;
        }

    }

}
