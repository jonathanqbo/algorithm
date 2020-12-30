package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/21/20 11:28 PM
 */
public class Q9PalindromNumber {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return x == rev || x == rev / 10;
    }

}
