package leecode.bq.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 *
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/7/21 9:28 PM
 */
public class Q46Permutations {

    /**
     solution: dfs + backtracking + in-place swap

                ()
        1(23)   2(13)    3(21)   KEY: switch i with other node in its right side
       2  3     1 3      2 1
     3     2   3   1    1   2

     dfs(startIdx, permutation array) :
     if startIdx == n: copy current permutation array to result
     for (int i = startIdx; i < n; i++):
     switch node (startIdx, i) in-palce permutation    // in-place swap, this is difference between combination and permutation
     dfs(startIdx + 1, permuation)                   // NOTE: next startIdx is startIdx+1, this is difference between combination and permutation
     switch node back in-place permutation

     NOTE: create a List from int[]

     */
    class Solution {

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            dfs(nums, 0, result);

            return result;
        }

        private void dfs(int[] nums, int startIdx, List<List<Integer>> result) {
            if (startIdx == nums.length - 1) {
                // stream casue timecost to 6ms from 0ms
                // result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                List<Integer> permutation = new ArrayList<>();
                for (int num : nums) {
                    permutation.add(num);
                }
                result.add(permutation);

                return;
            }

            for (int i = startIdx; i < nums.length; i++) {
                swap(nums, startIdx, i);
                dfs(nums, startIdx + 1, result);
                swap(nums, startIdx, i);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

    }

}
