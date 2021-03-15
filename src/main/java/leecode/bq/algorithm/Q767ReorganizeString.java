package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/10/21 8:28 PM
 */
public class Q767ReorganizeString {

    /**
     * solution: count then build
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reorganize String.
     * Memory Usage: 37 MB, less than 88.61% of Java online submissions for Reorganize String.
     *
     */
    class Solution {

        public String reorganizeString(String S) {
            // all lowercase letter
            int[] counts = new int[26];

            // count
            for (int i = 0; i < S.length(); i++) {
                counts[S.charAt(i) - 'a'] += 1;
            }

            // find the max and its letter
            int max = 0;
            int maxIndex = 0;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > max) {
                    max = counts[i];
                    maxIndex = i;
                }
            }

            // check if it's possible: max <= length/2 + 1
            // KEY: (length+1)/2, not length/2 + 1
            if (max > (S.length() + 1) / 2) {
                return "";
            }

            // KEY: put the max letter into result in format x_x_x_***
            char[] result = new char[S.length()];
            int idx = 0;
            char maxLetter = (char)(maxIndex + 'a');
            while (counts[maxIndex] > 0) {
                result[idx] = maxLetter;
                // note: update the count to void duplicate add later
                counts[maxIndex]--;

                idx += 2;
            }

            // put other letters
            for (int i = 0; i < counts.length; i++) {
                char c = (char)(i + 'a');
                while (counts[i] > 0) {
                    // start from index 1 after reaching to end
                    if (idx >= S.length()) {
                        idx = 1;
                    }

                    result[idx] = c;
                    idx += 2;
                    counts[i]--;
                }
            }

            return new String(result);
        }

    }

}
