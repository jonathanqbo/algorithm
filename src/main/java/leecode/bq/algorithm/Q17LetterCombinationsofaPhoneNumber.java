package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/15/21 11:47 PM
 */
public class Q17LetterCombinationsofaPhoneNumber {

    /**
     * solution: recursion
     *
     * Runtime: 1 ms, faster than 81.14% of Java online submissions for Letter Combinations of a Phone Number.
     * Memory Usage: 39.1 MB, less than 53.42% of Java online submissions for Letter Combinations of a Phone Number.
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        Map<Character, char[]> table = buildTable();
        return helper(table, digits, 0);
    }

    private List<String> helper(Map<Character, char[]> table, String digits, int start) {
        if (start == digits.length()) {
            return Arrays.asList("");
        }

        List<String> subResult = helper(table, digits, start + 1);

        List<String> result = new LinkedList<>();
        char[] cs = table.get(digits.charAt(start));
        for (char c: cs) {
            for (String substr: subResult) {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                sb.append(substr);
                result.add(sb.toString());
            }
        }

        return result;
    }

    private Map<Character, char[]> buildTable() {
        Map<Character, char[]> table = new HashMap<>();
        table.put('2', "abc".toCharArray());
        table.put('3', "def".toCharArray());
        table.put('4', "ghi".toCharArray());
        table.put('5', "jkl".toCharArray());
        table.put('6', "mno".toCharArray());
        table.put('7', "pqrs".toCharArray());
        table.put('8', "tuv".toCharArray());
        table.put('9', "wxyz".toCharArray());

        return table;
    }

}
