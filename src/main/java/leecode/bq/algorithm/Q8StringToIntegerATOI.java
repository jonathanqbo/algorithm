package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/15/21 10:15 PM
 */
public class Q8StringToIntegerATOI {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for String to Integer (atoi).
     * Memory Usage: 38.7 MB, less than 89.85% of Java online submissions for String to Integer (atoi).
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int result = 0;
        boolean isNegative = false;

        // step 1
        int i = 0, n = s.length();
        // key: check index range in every step
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // step 2
        // key: check index range in every step
        if (i >= n) {
            return 0;
        }

        char cur = s.charAt(i);
        if (cur == '-') {
            isNegative = true;
            i++;
        } else if (cur == '+') {
            i++;
        }

        // step 3+
        int maxN1 = Integer.MAX_VALUE / 10;
        int maxLeft = isNegative ? -(Integer.MIN_VALUE % 10) : Integer.MAX_VALUE % 10;
        while (i < n) {
            cur = s.charAt(i);
            if (cur > '9' || cur < '0') {
                break;
            }

            int curDigit = cur - '0';
            if (result > maxN1 || (result == maxN1 && curDigit > maxLeft)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                result = result * 10 + curDigit;
            }

            i++;
        }

        return isNegative ? -result : result;
    }

}
