package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/16/21 11:39 AM
 */
public class Q22GenerateParentheses {

    /**

     solution: dfs + backtracking

     think like this:
     ---------------
     build final 2n length str one char by one char
     in each index, it has two options, either "(" or ")"
     if "(" amount < n, add "("
     if ")" amount < "(" amount, add ")"

     dfs(int n, List<String> result, StringBuilder comb, int i, int openAmount, int closeAmount, )
     0) if comb.length() = 2n: add to result
     1) if open bracket amount < n: dfs(str, n - 1, comb.append "("), comb.delete last
     2) if close bracked amount < open bracket amount: dfs(str, n - 1, comb.append ")"), comb.delete last



     (
     ((           ()
     (((      (()         ()(
     (((( ((() (()( (())   ()((  ()()

     */

    class Solution {

        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            dfs(n, 0, 0, result, new StringBuilder());

            return result;
        }

        private void dfs(int n, int openBracket, int closeBracket, List<String> result, StringBuilder path) {
            if (path.length() == 2 * n) {
                result.add(path.toString());
                return;
            }

            if (openBracket < n) {
                path.append("(");
                dfs(n, openBracket + 1, closeBracket, result, path);
                path.deleteCharAt(path.length() - 1);
            }

            if (openBracket > closeBracket) {
                path.append(")");
                dfs(n, openBracket, closeBracket + 1, result, path);
                path.deleteCharAt(path.length() - 1);
            }
        }

    }

}
