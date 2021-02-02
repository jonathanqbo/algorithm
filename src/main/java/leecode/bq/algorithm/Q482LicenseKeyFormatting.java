package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/21/21 10:37 PM
 */
public class Q482LicenseKeyFormatting {

    /**
     * solution: iterate from end, then reverse StringBuilder
     * <p>
     * Runtime: 7 ms, faster than 93.86% of Java online submissions for License Key Formatting.
     * Memory Usage: 39.1 MB, less than 80.66% of Java online submissions for License Key Formatting.
     *
     * @param S
     * @param K
     * @return
     */
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder result = new StringBuilder();
        // key: here init rem = K + 1, to handle the first "-" case.
        // rem always point to the element one ahead of
        for (int i = S.length() - 1, groupIndicator = K + 1; i >= 0; i--) {
            if (S.charAt(i) == '-') continue;
            if (--groupIndicator == 0) {
                result.append("-");
                groupIndicator = K;
            }
            result.append(Character.toUpperCase(S.charAt(i)));
        }

        // StringBuilder reverse has an acceptable performance than doing multiple times StringBuilder.insert
        return result.reverse().toString();
    }

    /**
     * solution 2: intuition. not too bad in performance
     *
     * Runtime: 8 ms, faster than 85.67% of Java online submissions for License Key Formatting.
     * Memory Usage: 39.6 MB, less than 49.44% of Java online submissions for License Key Formatting
     *
     * @param S
     * @param K
     * @return
     */
    public String licenseKeyFormatting2(String S, int K) {
        StringBuilder result = new StringBuilder();

        String s2 = S.replace("-", "").toUpperCase();
        if (s2 == null || s2.isEmpty()) {
            return "";
        }

        int groups = s2.length() / K;
        int g1 = s2.length() % K;

        if (g1 == 0) {
            g1 = K;
        } else {
            groups++;
        }

        result.append(s2.substring(0, g1));

        for (int i = 1, j = g1; i < groups; i++, j += K) {
            result.append("-");
            result.append(s2.substring(j, j + K));
        }

        return result.toString();
    }

}
