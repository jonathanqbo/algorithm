package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/17/21 10:53 PM
 */
public class Q5LongestPalindromicSubstring {

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

    /**
     * solution 2: expand around center
     *
     * Runtime: 24 ms, faster than 80.08% of Java online submissions for Longest Palindromic Substring.
     * Memory Usage: 38.8 MB, less than 90.44% of Java online submissions for Longest Palindromic Substring.
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int from = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = palindrome(s, i, i);
            int len2 = palindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - from) {
                from = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(from, end + 1);
    }

    private int palindrome(String s, int centerL, int centerR) {
        int left = centerL;
        int right = centerR;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

}
