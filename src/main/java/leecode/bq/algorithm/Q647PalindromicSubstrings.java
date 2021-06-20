package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:22 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q647PalindromicSubstrings {

    /**

     solution: expand from all posible center

     */

// class Solution {
//     public int countSubstrings(String s) {

//     }
// }

    class Solution {
        public int countSubstrings(String s) {
            int ans = 0;

            for (int i = 0; i < s.length(); ++i) {
                // odd-length palindromes, single character center
                ans += countPalindromesAroundCenter(s, i, i);

                // even-length palindromes, consecutive characters center
                ans += countPalindromesAroundCenter(s, i, i + 1);
            }

            return ans;
        }

        private int countPalindromesAroundCenter(String ss, int lo, int hi) {
            int ans = 0;

            while (lo >= 0 && hi < ss.length()) {
                if (ss.charAt(lo) != ss.charAt(hi))
                    break;      // the first and last characters don't match!

                // expand around the center
                lo--;
                hi++;

                ans++;
            }

            return ans;
        }
    }

}
