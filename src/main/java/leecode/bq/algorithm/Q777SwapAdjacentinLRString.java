package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/23/21 10:30 PM
 */
public class Q777SwapAdjacentinLRString {

    /**
     * solution: two pointers
     * KEY: after removing X, two string should be same
     * ie: RX XR XL LX ==> R L
     *
     * Runtime: 3 ms, faster than 84.66% of Java online submissions for Swap Adjacent in LR String.
     * Memory Usage: 39.2 MB, less than 65.03% of Java online submissions for Swap Adjacent in LR String.
     *
     * @param start
     * @param end
     * @return
     */
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }

        int n = start.length();

        int countX = 0;
        for (int i = 0; i < n; i++) {
            char c1 = start.charAt(i);
            char c2 = end.charAt(i);
            if (c1 == 'X') {
                countX++;
            }
            if (c2 == 'X') {
                countX--;
            }
        }
        if (countX != 0) {
            return false;
        }

        int i1 = 0;
        int i2 = 0;
        while (i1 < n && i2 < n) {
            while (i1 < n && start.charAt(i1) == 'X') {
                i1++;
            }
            while (i2 < n && end.charAt(i2) == 'X') {
                i2++;
            }

            // here i1 or i2 could be n which will give IndexOutOfBoundsException in following code
            // so have to handle it here.
            // ["XXXLXXXXXX", "XXXLXXXXXX"]
            if (i1 == n || i2 == n) {
                return i1 == n && i2 == n;
            }

            char c1 = start.charAt(i1);
            char c2 = end.charAt(i2);
            if (c1 != c2) {
                return false;
            }
            if (c1 == 'L' && i1 < i2) {
                return false;
            }
            if (c1 == 'R' && i1 > i2) {
                return false;
            }

            i1++;
            i2++;
        }

        return true;
    }

}
