package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:26 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q791CustomSortString {

    /**

     solution: count and StringBuilder

     count all chars
     append chars in "order" by order (doing count--)
     then append other chars

     */

    class Solution {

        public String customSortString(String order, String str) {
            int[] count = new int[26];

            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < order.length(); i++) {
                char c = order.charAt(i);
                for (int j = 0; j < count[c - 'a']; j++) {
                    result.append(c);
                }
                count[c - 'a'] = 0;
            }

            for (int i = 0; i < count.length; i++) {
                // KEY: need force type cast
                char c = (char)('a' + i);
                for (int j = 0; j < count[i]; j++) {
                    result.append(c);
                }
            }

            return result.toString();
        }

    }

}
