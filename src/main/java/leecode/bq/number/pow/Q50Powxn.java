package leecode.bq.number.pow;

/**
 * <b> </b>
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/4/21 11:04 PM
 */
public class Q50Powxn {

    /**

     solution 1: recursion (simple)

     1. convert argument x, n if n < 0
     2. binary recursion

     KEY1:
     if n%2 == 0, pow(x, n) == pow(x, n/2) * pow(x, n/2)
     if n%2 == 1, pow(x, n) == pow(x, n/2) * pow(x, n/2) * x

     KEY2:
     if n < 0, pow(x, n) == power(1/x, -n) (KEY: n -> -n, might cause overflow, so use "long")

     */
    class Solution {

        public double myPow(double x, int n) {
            // key: n can be negative, convert to -n if n < 0
            // to handle negative n, x = 1/x, so also need to handle x == 0
            // -n could be overflow, so use long instead of int
            if (x == 0) {
                return 0;
            }

            return n < 0 ? pow(1 / x, -n) : pow(x, n);
        }

        private double pow(double x, long n) {
            if (n == 0) {
                return 1;
            }

            double subPow = pow(x, n / 2);
            return n % 2 == 0 ? subPow * subPow : subPow * subPow * x;
        }

    }

    class Solution1 {

        public double myPow(double x, int n) {
            if (x == 0) {
                return 0;
            }
            if (n == 0) {
                return 1;
            }

            long m = n;
            double y = x;
            if (n < 0) {
                m = -m;
                y = 1 / y;
            }

            double result = 1;
            while (m > 0) {
                long k = 1;
                double pow = y;
                while (k <= m / 2) {
                    k *= 2;
                    pow *= pow;
                }

                m -= k;
                result *= pow;
            }

            return result;
        }

    }

}
