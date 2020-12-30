package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/25/20 2:54 PM
 */
public class Q69Sqrt {

    /**
     * Runtime: 72 ms, faster than 5.05% of Java online submissions for Sqrt(x).
     * Memory Usage: 36.3 MB, less than 31.12% of Java online submissions for Sqrt(x).
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0)
            return 0;

        int i = 1;
        // the key is to use '/' instead of 'i * i <= x' to avoid overflow.
        while ( x / i >= i) {
            i++;
        }

        return i - 1;
    }

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Sqrt(x).
     * Memory Usage: 36 MB, less than 62.99% of Java online submissions for Sqrt(x).
     *
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x <= 1)
            return x;

        int i = 1, j = x, m;
        // the key is to use '/' instead of 'i * i <= x' to avoid overflow.
        while ( i < j) {
            m = (i + j) / 2;
            // result of x / m is int
            if (x / m >= m)
                i = m + 1;
            else
                j = m;


        }

        return j - 1;
    }

    public static void main(String[] args) {
        Q69Sqrt q = new Q69Sqrt();
        System.out.println(q.mySqrt(2147395600));
        System.out.println(289398 * 289398);
        System.out.println(289399 * 289399);
        System.out.println(Math.sqrt(2147395600));
        System.out.println(46340 * 46340);
        System.out.println(46341 * 46341);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(8/3);
    }

}
