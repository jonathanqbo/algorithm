package leecode.bq.algorithm;

import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/21/21 10:42 PM
 */
public class Q246StrobogrammaticNumber {

    /**
     * solution: two pointer
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Strobogrammatic Number.
     * Memory Usage: 36.8 MB, less than 62.29% of Java online submissions for Strobogrammatic Number.
     *
     * @param num
     * @return
     */
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = Map.of('1', '1', '6', '9', '8', '8', '9', '6', '0', '0');

        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            char c1 = num.charAt(left);
            char c2 = num.charAt(right);
            if (!map.containsKey(c1) || !map.get(c1).equals(c2)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
