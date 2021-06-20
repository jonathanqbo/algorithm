package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:57 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q216CombinationSumIII {

    /**

     solution: dfs + backtracking

     Two differences than other combination problem:
     1. end condition is: combination.size == k AND remain == 0
     2. in each dfs, valid candidate is: 1-9 (instead of n in other problem)

     */


    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            dfs(n, k, n, 1, new ArrayList<Integer>(), result);

            return result;
        }

        private void dfs(int n, int length, int remain, int startNum, List<Integer> combination, List<List<Integer>> result) {
            // KEY1: end condition
            if (combination.size() == length && remain == 0) {
                result.add(new ArrayList<>(combination));
                return;
            }
            if (remain < 0 || combination.size() == length) {
                return;
            }

            //KEY2: only use 1-9
            for (int i = startNum; i <= 9; i++) {
                combination.add(i);
                dfs(n, length, remain - i, i + 1, combination, result);
                combination.remove(combination.size() - 1);
            }
        }
    }

}