package leecode.bq.number.pow;

/**
 * <b> </b>
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.
 *
 *
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 *
 * <p>
 * Created at 6/13/21 8:42 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q29DivideTwoIntegers {

    /**

     solution: use - to achieve /

     simple solution: keep -divisor until dividend <= 0

     ---------

     solution2 (preferred): double -divisor every time (binary double from 1 to 2 -> 4 -> 8)

     KEY: when value*2 > dividend: dividend -= value, and continue the same while loop
     (good code template to remember!)

     KEY: to avoid Integer overflow, convert to negative number.
     There is a special case that needs to be handled specifically: -2147483648 / -1 == 2147483647


     ****FAST POW CODE TEMPLATE****

     */
    class Solution {

        public int divide(int dividend, int divisor) {
            if (divisor == 0) {
                return Integer.MAX_VALUE;
            }

            // key: special handle: -2147483648/-1 = 2147483647
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }

            if (dividend == 0) {
                return 0;
            }

            // Trick: to get if two number have same sign
            boolean sameSign = (dividend >=0) == (divisor >=0);

            // KEY: convert positive number to negative to avoid overflow
            if (dividend > 0) {
                dividend = -dividend;
            }
            if (divisor > 0) {
                divisor = -divisor;
            }

            // Code template for quick power
            int result = 0;
            while (dividend <= divisor) {
                int power = 1;
                int subDividend = divisor;
                // KEY: also need to check if subDividend + subDividend is overflow
                while (subDividend >= Integer.MIN_VALUE - subDividend && subDividend >= dividend - subDividend) {
                    power += power;
                    subDividend += subDividend;
                }

                result += power;
                dividend -= subDividend;
            }

            return sameSign ? result : -result;
        }

    }

}