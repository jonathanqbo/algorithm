package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/25/21 10:25 PM
 */
public class Q43MultiplyStrings {

    /**
     * solution: this is general multiplication algorithm
     *
     * Runtime: 3 ms, faster than 91.16% of Java online submissions for Multiply Strings.
     * Memory Usage: 39.3 MB, less than 39.44% of Java online submissions for Multiply Strings.
     *
     * @param n1
     * @param n2
     * @return
     */
    public String multiply(String n1, String n2) {
        int m = n1.length();
        int n = n2.length();

        // max length is m + n
        int[] result = new int[m + n];

        // calculate from last digit
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int r1 = (n1.charAt(i) - '0') * (n2.charAt(j) - '0') + result[i + j + 1];
                // result[i + j] = the carry + result[i + j]
                // the value in result[i + j] could >= 10 during the process
                // but finally it will be all handled properly
                result[i + j] += r1 / 10;
                // the mod is result[i + j + 1]
                result[i + j + 1] = r1 % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        // i < result.length for edge case: "0" x "0"
        while (i < result.length && result[i] == 0) {
            i++;
        }
        for (; i < result.length; i++) {
            sb.append(result[i]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

}
