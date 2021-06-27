package leecode.bq.number;

/**
 * <b> </b>
 *
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/21/20 11:28 PM
 */
public class Q7ReverseInteger {

    /**
     *
    solution: Digit operation

    while until x == 0
        get last digit: mod = x%10
        add to result: result = result * 10 + mod
        get left num:  x = x/10

    KEY: check Overflow, see code below


    NOTE: don't need to distinguish negative number and positive number
    -11 % 10 == -1
    -11 / 10 == -1

    */
    class Solution {

        public int reverse(int x) {
            int maxSecondIntOfNegative = Integer.MIN_VALUE / 10;
            int maxSecondIntOfPositive = Integer.MAX_VALUE / 10;
            int maxLastDigitOfNegative = Integer.MIN_VALUE % 10;
            int maxLastDigitOfPositive = Integer.MAX_VALUE % 10;

            int result = 0;
            int num = x;
            // NOTE: unitl num == 0
            while (num != 0) {
                int digit = num % 10;
                num = num / 10;

                if (result > maxSecondIntOfPositive ||
                        (result == maxSecondIntOfPositive && digit > maxLastDigitOfPositive)) {
                    return 0;
                }
                if (result < maxSecondIntOfNegative ||
                        (result == maxSecondIntOfNegative && digit < maxLastDigitOfNegative)) {
                    return 0;
                }

                result = result * 10 + digit;
            }

            return result;
        }

    }

}
