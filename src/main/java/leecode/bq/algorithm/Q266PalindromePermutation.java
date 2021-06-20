package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 9:26 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q266PalindromePermutation {

    /**

     solution 1: HashMap count

     solution 2: use int[128] instead of HashMap

     solution 3: one pass using int[128]

     */

    class Solution {

        public boolean canPermutePalindrome(String s) {
            int[] charToCount = new int[128];

            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                charToCount[c]++;

                if (charToCount[c] % 2 == 0) {
                    count--;
                } else {
                    count++;
                }
            }

            return count == 1 || count == 0;
        }

    }

}
