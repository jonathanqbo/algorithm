package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/16/21 11:39 AM
 */
public class Q22GenerateParentheses {

    /**
     * solution: treat as Tree, check each possible child node which can add "(" or add ")"
     *
     * Runtime: 1 ms, faster than 84.43% of Java online submissions for Generate Parentheses.
     * Memory Usage: 39.2 MB, less than 63.69% of Java online submissions for Generate Parentheses.
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        dfs("", 0, 0, n, result);
        return result;
    }

    private void dfs(String cur, int openN, int closeN, int n, List<String> result) {
        if (openN == closeN && closeN == n) {
            result.add(cur);
            return;
        }

        if (openN < n) {
            dfs(cur + "(", openN + 1, closeN, n, result);
        }

        if (closeN < openN) {
            dfs(cur + ")", openN, closeN + 1, n, result);
        }
    }



    Map<Integer, List<String>> mem = new HashMap<>();

    /**
     * solution 2: treat () together.
     *
     * Runtime: 1 ms, faster than 84.43% of Java online submissions for Generate Parentheses.
     * Memory Usage: 38.8 MB, less than 96.82% of Java online submissions for Generate Parentheses.
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        if (n == 0) {
            return Arrays.asList("");
        }

        if (mem.containsKey(n)) {
            return mem.get(n);
        }

        List<String> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (String left: generateParenthesis(i)) {
                for (String right: generateParenthesis(n - 1 - i)) {
                    result.add(new StringBuilder().append("(").append(left).append(")").append(right).toString());
                }
            }
        }

        mem.put(n, result);

        return result;
    }

}
