package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/6/21 9:48 AM
 */
public class Q49GroupAnagrams {

    /**
     * solution 1: group by sorted string
     *
     * Runtime: 12 ms, faster than 40.11% of Java online submissions for Group Anagrams.
     * Memory Usage: 52.8 MB, less than 16.35% of Java online submissions for Group Anagrams.
     *
     */
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> sortedWordToList = new HashMap<>();

            for (String str: strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String sortedStr = String.valueOf(chars);

                sortedWordToList.putIfAbsent(sortedStr, new ArrayList<>());
                sortedWordToList.get(sortedStr).add(str);
            }

            return new ArrayList(sortedWordToList.values());
        }
    }


    /**
     * solution 2: group by pattern (counting)
     *
     * Runtime: 12 ms, faster than 40.11% of Java online submissions for Group Anagrams.
     * Memory Usage: 52.8 MB, less than 16.35% of Java online submissions for Group Anagrams.
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> patternToList = new HashMap<>();

        for (String str: strs) {
            char[] chars = str.toCharArray();

            // way 1: use int[], runtime 29 ms
//             int[] pattern = new int[26];
//             for (char c: str.toCharArray()) {
//                 pattern[c- 'a'] += 1;
//             }

//             StringBuilder sb = new StringBuilder();
//             for (int count: pattern) {
//                 sb.append('#');
//                 sb.append(count);
//             }
//             String patternStr = sb.toString();

            // way 2: use char[] as counter, runtime 9 ms
            char[] pattern = new char[26];
            for(int i = 0; i< str.length();i++){
                pattern[str.charAt(i) - 'a']++;
            }
            String patternStr = new String(pattern);

            patternToList.putIfAbsent(patternStr, new ArrayList());
            patternToList.get(patternStr).add(str);
        }

        return new ArrayList(patternToList.values());
    }

}
