package leecode.bq.number;

/**
 * <b> </b>
 *
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 *
 *
 * Example 1:
 *
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 *          ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 *          ^
 * Step 3: "42" ("42" is read in)
 *            ^
 * The parsed integer is 42.
 * Since 42 is in the range [-231, 231 - 1], the final result is 42.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/15/21 10:15 PM
 */
public class Q8StringToIntegerATOI {

    /**

     solution: just follow the steps

     NOTE: code to check if number overflow:

     int maxN1 = sign == -1 ? -(Integer.MIN_VALUE / 10) : Integer.MAX_VALUE / 10;
     int maxLeft = sign == -1 ? -(Integer.MIN_VALUE % 10) : Integer.MAX_VALUE % 10;

     if ((num == maxN1 && curDigit > maxLeft) || num > maxN1) {
     return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
     }

     */
    class Solution {

        public int myAtoi(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }

            int n = s.length();

            // step 1
            int i = 0;
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }

            // KEY: after step 1, i could be s.length()
            if (i == n) {
                return 0;
            }

            // step 2
            char sign = s.charAt(i);
            boolean isNegative = false;
            if (sign == '-') {
                isNegative = true;
                i++;
            } else if (sign == '+') {
                i++;
            }

            // NOTE: leading zero can be also handled in same way
            int maxN1Number = isNegative ? -(Integer.MIN_VALUE / 10) : Integer.MAX_VALUE / 10;
            int maxLastDigit = isNegative ? -(Integer.MIN_VALUE % 10) : Integer.MAX_VALUE % 10;

            int result = 0;
            while (i < n) {
                char c = s.charAt(i);
                if (!Character.isDigit(c)) {
                    break;
                }

                int digit = c - '0';

                if (result > maxN1Number || (result == maxN1Number && digit > maxLastDigit)) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }

                result = result * 10 + digit;
                i++;
            }

            return isNegative ? - result : result;
        }

    }

}
