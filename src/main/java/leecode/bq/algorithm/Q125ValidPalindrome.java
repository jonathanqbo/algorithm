package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/15/21 9:06 PM
 */
public class Q125ValidPalindrome {

    /**
     * solution: two pointers
     *
     * Runtime: 2 ms, faster than 97.90% of Java online submissions for Valid Palindrome.
     * Memory Usage: 39.2 MB, less than 60.13% of Java online submissions for Valid Palindrome.
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int n = s.length();
        int left = 0, right = n - 1;

        while (left < right) {
            char leftC = s.charAt(left);
            if (!isalphanum(leftC)) {
                left++;
                continue;
            }

            char rightC = s.charAt(right);
            if (!isalphanum(rightC)) {
                right--;
                continue;
            }

            if (Character.toLowerCase(leftC) != Character.toLowerCase(rightC)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isalphanum(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <='Z') ||
                (c >= '0' && c <= '9');
    }

}
