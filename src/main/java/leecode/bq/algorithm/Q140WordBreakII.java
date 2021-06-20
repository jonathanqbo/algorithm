package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:55 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q140WordBreakII {

    /**
     * solution (brute force): DFS + backtracking without mem
     * <p>
     * time complexity: O(2^N). N is length of s. total tree node is 2^N
     * space complexity: O(N). tree depth is N
     * <p>
     * if count substring9():
     * time complexity: O(N2^N).
     * space complexity: O(N).
     */
    class Solution1 {

        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);

            List<String> result = new ArrayList<>();
            dfs(s, dict, 0, new StringBuilder(), result);

            return result;
        }

        private void dfs(String str, Set<String> dict, int startIdx, StringBuilder sentence, List<String> result) {
            if (startIdx == str.length()) {
                result.add(sentence.toString().trim());
                return;
            }

            for (int i = startIdx + 1; i <= str.length(); i++) {
                String prefix = str.substring(startIdx, i);
                if (dict.contains(prefix)) {
                    sentence.append(prefix).append(" ");
                    dfs(str, dict, i, sentence, result);
                    sentence.delete(sentence.length() - prefix.length() - 1, sentence.length());
                }
            }
        }

    }


    /**
     * solution 2: DFS + mem without backtracking
     * <p>
     * NOTE: use this solution for interview, since this logic is same as 139. Word Break
     * <p>
     * time complexity: O(N^3) (count substring). same as Word Break
     * space complexity: O(N)
     *
     * @see 139. Word Break
     */
    class Solution {

        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);

            Map<String, List<String>> mem = new HashMap<>();
            return dfs(s, dict, mem);
        }

        private List<String> dfs(String str, Set<String> dict, Map<String, List<String>> mem) {
            if (str == null || str.isEmpty()) {
                return Arrays.asList("");
            }

            if (mem.containsKey(str)) {
                return mem.get(str);
            }

            List<String> result = new ArrayList<>();
            for (int i = 1; i <= str.length(); i++) {
                String prefix = str.substring(0, i);
                if (dict.contains(prefix)) {
                    for (String subResult : dfs(str.substring(i), dict, mem)) {
                        result.add(new StringBuilder().append(prefix).append(" ").append(subResult).toString().trim());
                    }
                }
            }

            mem.put(str, result);
            return result;
        }

    }

}
