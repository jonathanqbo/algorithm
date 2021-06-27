package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 *
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Example 3:
 *
 * Input: haystack = "", needle = ""
 * Output: 0
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/23/20 9:45 PM
 */
public class Q28ImplementStrStr_X {

    /**

     solution 1: brute force

     --------

     solution 2 (TODO): KMP algorithm

     */
    class Solution {
        public int strStr(String haystack, String needle) {
            int lengthHaystack = haystack.length();
            int lengthNeedle = needle.length();

            if (lengthNeedle == 0)
                return 0;

            if (lengthHaystack < lengthNeedle)
                return -1;

            int loops = lengthHaystack - lengthNeedle + 1;
            for (int i = 0; i < loops; i++) {
                int j = 0;
                while (j < lengthNeedle && needle.charAt(j) == haystack.charAt(i + j)) {
                    j++;
                }

                if (j == lengthNeedle)
                    return i;
            }

            return -1;
        }
    }

}
