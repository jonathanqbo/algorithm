package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:42 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */

/**

 solution: use - to achieve /

 simple solution: keep -divisor until dividend <= 0

 ---------

 optimal solution: double -divisor every time (binary double from 1 to 2 -> 4 -> 8)

 KEY: when value*2 > dividend: dividend -= value, and continue the same while loop
 (good code template to remember!)

 KEY: to avoid Integer overflow, convert to negative number.
 There is a special case that needs to be handled specifically: -2147483648 / -1 == 2147483647


 ****FAST POW CODE TEMPLATE****

 */
public class Q29DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isSameSign = (dividend >= 0) == (divisor >= 0);
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        int result = 0;
        while (dividend <= divisor) {
            int pow = 1;
            int sum = divisor;
            // KEY: check if value after doubled is more than dividend
            // KEY: also check if value after doubled is overflow
            while (Integer.MIN_VALUE - sum <= sum && dividend - sum <= sum) {
                sum += sum;
                pow += pow;
            }

            dividend -= sum;
            result += pow;
        }

        return isSameSign ? result : -result;
    }

}