package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/24/21 10:17 PM
 */
public class Q415AddStrings {

    /**
     * solution: Elementary Math
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Strings.
     * Memory Usage: 38.9 MB, less than 84.86% of Java online submissions for Add Strings.
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int carry = 0;
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;

            int sum = x1 + x2 + carry;
            carry = sum / 10;
            result.append(sum % 10);

            p1--;
            p2--;
        }

        // NOTE: don't miss the last carry
        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

}
