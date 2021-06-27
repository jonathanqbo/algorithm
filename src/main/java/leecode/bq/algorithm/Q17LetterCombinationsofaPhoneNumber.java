package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/15/21 11:47 PM
 */
public class Q17LetterCombinationsofaPhoneNumber {

    class Solution {
        Map<Character, String> digitToLetters = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.isEmpty()) {
                return Collections.emptyList();
            }

            List<String> result = new ArrayList<>();
            dfs(digits, 0, result, new StringBuilder());

            return result;
        }

        private void dfs(String digits, int i, List<String> result, StringBuilder path) {
            if (i == digits.length()) {
                result.add(path.toString());
                return;
            }

            char digit = digits.charAt(i);

            if (digitToLetters.containsKey(digit)) {
                for (char c : digitToLetters.get(digit).toCharArray()) {
                    path.append(c);
                    dfs(digits, i + 1, result, path);
                    path.deleteCharAt(path.length() - 1);
                }
            }
        }

    }

}
