package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 9:22 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q249GroupShiftedStrings {

    /**

     bcd -> offset 1 -> 1_2_3 -> 0 _1_2 -> abc

     cba -> offset 2 -> 2_1_0 -> 0_-1_-2 -> 0_25_24 -> azy

     */
    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            Map<String, List<String>> groups = new HashMap<>();

            for (String str : strings) {
                String pattern = pattern(str);
                groups.computeIfAbsent(pattern, k -> new ArrayList<>()).add(str);
            }

            List<List<String>> result = new ArrayList<>();
            groups.values().forEach(result::add);

            return result;
        }

        private String pattern(String str) {
            StringBuilder result = new StringBuilder();

            int offset = str.charAt(0) - 'a';
            result.append(0).append('_');

            for (int i = 1; i < str.length(); i++) {
                int shifted = str.charAt(i) - 'a' - offset;
                // KEY: handle negative shift
                if (shifted < 0) {
                    shifted += 26;
                }

                result.append(shifted).append('_');
            }

            return result.toString();
        }
    }
}
