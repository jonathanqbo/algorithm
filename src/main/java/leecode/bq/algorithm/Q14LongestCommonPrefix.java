package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/22/20 8:24 PM
 */
public class Q14LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty())
                    return "";
            }
        return prefix;
    }

    /**
     * worse performance
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0)
            return "";

        if (strs.length == 1)
            return strs[0];

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (prefix.isEmpty())
                return "";

            int minLength = Math.min(prefix.length(), strs[i].length());
            int j = 0;
            while (j < minLength && prefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            prefix = prefix.substring(0, j);
        }

        return prefix;
    }

}
