package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:48 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */

import java.util.ArrayList;
import java.util.List;

/**

 dfs(startNum, combination):
 if combination.size == k: add to result           => combination.size == length
 for startNum to n:
 combination.add(num)
 dfs(startNum + 1, combination)                => startNum+1
 combination.removelast

 */

class Q77Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<Integer>(), result);

        return result;
    }

    private void dfs(int n, int length, int startNum, List<Integer> combination, List<List<Integer>> result) {
        if (combination.size() == length) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = startNum; i < n + 1; i++) {
            combination.add(i);
            dfs(n, length, i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }

}
