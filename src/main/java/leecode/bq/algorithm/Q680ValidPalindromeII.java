package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/27/21 11:16 AM
 */
public class Q680ValidPalindromeII {

    /**
     * solution: recursion
     *
     * Runtime: 9 ms, faster than 30.72% of Java online submissions for Valid Palindrome II.
     * Memory Usage: 51.9 MB, less than 8.57% of Java online submissions for Valid Palindrome II.
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int n = s.length();

        int left = 0, right = n - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
                continue;
            }

            return isValidPalindrome(s, left + 1, right) || isValidPalindrome(s, left, right - 1);
        }

        return true;
    }

    private boolean isValidPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
