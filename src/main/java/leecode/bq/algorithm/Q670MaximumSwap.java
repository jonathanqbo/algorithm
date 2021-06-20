package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:23 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q670MaximumSwap {

    /**

     solution: Two pass

     1) right -> left: keep track cur Max

     [9 8 3 6 8]
     [9 8 8 8 8]

     2) left -> right: find the first i that < its max

     NOTE: keep the index instead of value, for later swap

     */

    class Solution {

        public int maximumSwap(int num) {
            char[] chars = Integer.toString(num).toCharArray();

            int[] maxIdxs = new int[chars.length];
            int maxIdx = chars.length - 1;
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] > chars[maxIdx]) {
                    maxIdx = i;
                }

                maxIdxs[i] = maxIdx;
            }

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] < chars[maxIdxs[i]]) {
                    char tmp = chars[i];
                    chars[i] = chars[maxIdxs[i]];
                    chars[maxIdxs[i]] = tmp;

                    return Integer.parseInt(String.valueOf(chars));
                }
            }

            return num;
        }

    }

}
