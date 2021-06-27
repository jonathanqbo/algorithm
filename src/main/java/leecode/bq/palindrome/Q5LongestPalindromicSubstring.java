package leecode.bq.palindrome;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/17/21 10:53 PM
 */
public class Q5LongestPalindromicSubstring {

    /**
     solution1 (preferred): Expand from center

     check each char as palindrome string center:

     note: there are two scenarioes as center: 1) the char is center, 2) center has two char, and the digit is left side of center

     KEY/Trick: to avoid calculate every possible palindrome string, we only calculate the length. Then calculat from/to from len: len could be odd or even, see code below

     two cases: for example, for len = 6, i

     # # i # # #    ==> from = i - (len - 1) / 2, to = i + len / 2;
     # # # i # # #  ==> from = i - (len - 1) / 2, to = i + len / 2;

     Time complexity: O(N^2)
     Space complxity: O(1)

     -------------------

     solution 2: dp,
     dp[i][j]: substring[i:j] is palindrom
     dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
     base: dp[i][i] == true, dp[i][i+1] == s[i]==s[i+1]

     -------------------

     solution3: Manacher's Algorithm

     */
    class Solution {

        public String longestPalindrome(String s) {
            int n = s.length();
            int resultFrom = 0, resultTo = 0;

            for (int i = 0; i < n; i++) {
                int len1 = palindromeStr(s, i, i);
                int len2 = palindromeStr(s, i, i + 1);

                int len = Math.max(len1, len2);
                if ( len > resultTo - resultFrom + 1) {
                    // KEY: calculate from/to from len
                    resultFrom = i  - (len - 1)/ 2 ;
                    resultTo = i + len / 2;
                }
            }

            return s.substring(resultFrom, resultTo + 1);
        }

        // KEY: return length instead of the string
        private int palindromeStr(String s, int centerLeft, int centerRight) {
            int left = centerLeft, right = centerRight;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            return right - left - 2 + 1;
        }

    }

    /**
     * solution 1: DP
     *
     * Runtime: 135 ms, faster than 37.15% of Java online submissions for Longest Palindromic Substring.
     * Memory Usage: 42.7 MB, less than 28.58% of Java online submissions for Longest Palindromic Substring.
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] d = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            d[i][i] = true;
        }

        int[] result = new int[2];

        for (int i = 0; i < n - 1; i++) {
            d[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (d[i][i + 1]) {
                result[0] = i;
                result[1] = i + 1;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                d[j][j + i] = d[j + 1][j + i - 1] ? s.charAt(j) == s.charAt(j + i) : false;
                if (d[j][j + i]) {
                    result[0] = j;
                    result[1] = j + i;
                }
            }

            // this drop runtime from 240 ms to 130 ms
            if (i > result[1] - result[0] + 2) {
                break;
            }
        }

        return s.substring(result[0], result[1] + 1);
    }
}
