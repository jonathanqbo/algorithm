package leecode.bq.palindrome;

/**
 * <b> </b>
 *
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/21/20 11:28 PM
 */
public class Q9PalindromNumber {

    /**

     solution1 (preferred): reverse number and check if it equals to x

     ------

     solution2: revert only half of number

     TRICK: to avoid overflow, the end condition is: reverse >= x

     */

    class Solution1 {

        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            int reverse = 0;
            int num = x;
            while (num > 0) {
                int digit = num % 10;

                if (reverse > Integer.MAX_VALUE / 10 ||
                        (reverse == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                    return false;
                }

                reverse = reverse * 10 + num % 10;
                num = num / 10;
            }

            return x == reverse;
        }
    }


    class Solution {

        public boolean isPalindrome(int x) {
            // KEY: have to handle x=10,20,30,100..., otherwise will get wrong result
            // because while(x > reverse): x=100 ==> reverse=1, x=0, ==> x == reverse/10 ==> true (incorrect result)
            if (x < 0 || (x % 10 == 0 && x != 0))
                return false;

            int reverse = 0;
            while (x > reverse) {
                reverse = reverse * 10 + x % 10;
                x = x / 10;
            }

            return x == reverse || x == reverse / 10;
        }

    }

}
