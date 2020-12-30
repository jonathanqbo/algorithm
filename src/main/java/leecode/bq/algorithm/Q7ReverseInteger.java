package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/21/20 11:28 PM
 */
public class Q7ReverseInteger {

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            // Integer.MAX_VALUE: 2147483647
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;

            // Integer.MIN_VALUE: -2147483648
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;


            rev = rev * 10 + pop;
        }

        return rev;
    }

}
