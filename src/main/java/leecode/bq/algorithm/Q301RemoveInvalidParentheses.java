package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 9:55 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q301RemoveInvalidParentheses {

    /**

     solution: dfs + backtracking

     for each open/close bracket, either include it or drop it.
     to better handle the inclusion and drop, we can know which bracket need be drop and include, and when to end dfs by knowing the total min amount of open/close brackets


     1. calculate min amount of open/close brackets to remove
     2. dfs + backtracking for char on s from left to right:
     update open and close bracket amount
     if open/close not balanced, remove it, and min amount--
     else include it, continue


     Without limited backtracking:
     time complexity: O(2^N). N is the length of s
     space complexity: O(N).

     with limited backtracking:
     same as before in worst case, for example: (((((, each position all have 2 options: drop or keep.

     */


    class Solution {

        public List<String> removeInvalidParentheses(String s) {
            // calculate the minimal amount open/close brackets that need to be removed
            int openBracketToRemove = 0;
            int closeBracketToRemove = 0;

            int balance = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '(') {
                    balance++;
                } else if (c == ')') {
                    balance--;
                    if (balance < 0) {
                        closeBracketToRemove++;
                        balance = 0;
                    }
                }
            }

            openBracketToRemove = balance;

            // Use set to remove duplicates
            Set<String> result = new HashSet<>();

            dfs(s, 0, 0, openBracketToRemove, closeBracketToRemove, new StringBuilder(), result);

            return new ArrayList<String>(result);
        }

        private void dfs(String str, int startIdx, int balance, int openToRemove, int closeToRemove, StringBuilder combination, Set<String> result) {
            if (startIdx == str.length()) {
                if (balance == 0) {
                    result.add(combination.toString());
                }
                return;
            }

            char c = str.charAt(startIdx);

            // drop cases
            if (c == '(' && openToRemove > 0) {
                dfs(str, startIdx + 1, balance, openToRemove - 1, closeToRemove, combination, result);
            } else if (c == ')' && closeToRemove > 0) {
                dfs(str, startIdx + 1, balance, openToRemove, closeToRemove - 1, combination, result);
            }

            // keep cases
            combination.append(c);

            if (c != ')' && c != '(') {
                dfs(str, startIdx + 1, balance, openToRemove, closeToRemove, combination, result);
            } else if (c == '(') {
                dfs(str, startIdx + 1, balance + 1, openToRemove, closeToRemove, combination, result);
            } else if (c == ')' && balance > 0) {
                dfs(str, startIdx + 1, balance - 1, openToRemove, closeToRemove, combination, result);
            }

            combination.deleteCharAt(combination.length() - 1);
        }

    }

}
