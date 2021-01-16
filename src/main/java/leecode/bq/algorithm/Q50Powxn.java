package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/4/21 11:04 PM
 */
public class Q50Powxn {

    /**
     * solution 1: recursion
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Pow(x, n).
     * Memory Usage: 38.4 MB, less than 40.29% of Java online submissions for Pow(x, n).
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        // int m = n;
        // use long here to avoid int overflow below
        long m = n;
        double y = x;
        if (n < 0) {
            // this could cause int overflow
            m = -n;
            y = 1 / x;
        }

        return pow(y, m);
    }

    private double pow(double x, long n) {
        if (n == 0)
            return 1.0;
        if (n == 1)
            return x;

        double r = pow(x, n / 2);
        return (n % 2 == 0) ? r * r : r * r * x;
    }

}
