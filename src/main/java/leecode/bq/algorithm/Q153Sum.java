package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/23/21 3:13 PM
 */
public class Q153Sum {

    /**
     solution 2 (prefered): sort + two pointers

     (since here needs find all combination, so not able to use binary search as in TwoSum II)

     KEY: no needs to use Set to to avoid duplication
     KEY: keep moving left pointer when found a result, and skip same num in twosum loop

     NOTE: this solution is also good for 3sum closest etc.

     */
    class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(nums);

            for (int i = 0; i < n; i++) {
                int cur = nums[i];
                // key: skip same num
                if (i > 0 && cur == nums[i - 1]) {
                    continue;
                }

                // two pointers for twosum in sorted array
                int need = -cur;
                int left = i + 1, right = n - 1;
                while (left < right) {
                    if (nums[left] + nums[right] < need) {
                        left++;
                    } else if (nums[left] + nums[right] > need) {
                        right--;
                    } else {
                        result.add(List.of(cur, nums[left], nums[right]));
                        // key: skip same num
                        while (left < n - 1 && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    }
                }
            }

            return result;
        }

    }

    /**
     solution 1 (o(n^2)): convert to two sums on each nums[i]

     foreach nums[i]
     if same num has been visited, continue
     twosum on the arr[i+1:] : twosum(nums, i + 1, -nums[i])

     Key: to avoid duplication, use Set<List<Integer>> and sort the List before adding to Set

     Time complexity: O(N^2)
     Space complexity: O(N)

     */
    class Solution2 {

        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> result = new HashSet<>();

            // key: avoid duplicate calculation
            Set<Integer> dups = new HashSet<>();
            for (int i = 0; i < nums.length - 2; i++) {
                if (dups.add(nums[i])) {
                    twoSum(nums, i, result);
                }
            }

            return new ArrayList(result);
        }

        private void twoSum(int[] nums, int i, Set<List<Integer>> result) {
            int target = -nums[i];
            Set<Integer> seen = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (seen.contains(target - nums[j])) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], target - nums[j]);
                    Collections.sort(triplet);
                    result.add(triplet);
                }

                seen.add(nums[j]);
            }
        }

    }


}
