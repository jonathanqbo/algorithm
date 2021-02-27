package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/26/21 9:05 PM
 */
public class Q509FibonacciNumber {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
     * Memory Usage: 36.1 MB, less than 26.15% of Java online submissions for Fibonacci Number.
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }

        return b;
    }


    /**
     * Runtime: 7 ms, faster than 24.54% of Java online submissions for Fibonacci Number.
     * Memory Usage: 35.8 MB, less than 43.67% of Java online submissions for Fibonacci Number.
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

}
