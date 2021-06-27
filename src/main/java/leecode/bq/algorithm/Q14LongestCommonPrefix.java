package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/22/20 8:24 PM
 */
public class Q14LongestCommonPrefix {

    /**

     solution: compare words one by one and find the LCP

     */
    class Solution {

        public String longestCommonPrefix(String[] strs) {
            String lcp = strs[0];
            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];
                int minLen = Math.min(str.length(), lcp.length());

                int j = 0;
                while (j < minLen && str.charAt(j) == lcp.charAt(j)) {
                    j++;
                }
                lcp = str.substring(0, j);
            }

            return lcp;
        }

    }

}
