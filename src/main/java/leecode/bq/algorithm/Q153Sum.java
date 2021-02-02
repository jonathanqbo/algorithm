package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/23/21 3:13 PM
 */
public class Q153Sum {

    /**
     * solution 1: sort -> two sum by two pointers
     *
     * Runtime: 16 ms, faster than 97.55% of Java online submissions for 3Sum.
     * Memory Usage: 43.2 MB, less than 54.23% of Java online submissions for 3Sum.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList();
        // key: only loop nums[i] <= 0
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                // could have multiple two sum, pass result to save performance
                twoSum(nums, i, result);
            }
        }

        return result;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int left = i + 1, right = nums.length - 1;
        int target = -nums[i];
        while (left < right) {
            if (nums[left] > target) {
                return;
            }

            int sum = nums[right] + nums[left];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                left++;
                // key
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
    }

    /**
     * solution: sort -> two pointers by hashset
     *
     * Runtime: 198 ms, faster than 31.49% of Java online submissions for 3Sum.
     * Memory Usage: 43.3 MB, less than 47.91% of Java online submissions for 3Sum.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new LinkedList();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                // could have multiple two sum, pass result to save performance
                twoSum2(nums, i, result);
            }
        }

        return result;
    }

    private void twoSum2(int[] nums, int i, List<List<Integer>> result) {
        Set<Integer> set = new HashSet();
        int left = i + 1;
        int target = -nums[i];
        while (left < nums.length) {
            // check target - nums[left] first, then add nums[left] into set
            // since it could be: target - nums[left]  == nums[left]
            if (set.contains(target - nums[left])) {
                result.add(Arrays.asList(nums[i], nums[left], target - nums[left]));
                // left point to the last one that has same value
                while (left < nums.length -1 && nums[left] == nums[left + 1]) {
                    left++;
                }
            }
            set.add(nums[left]);

            left++;
        }
    }

    /**
     * solution 3: without sort
     *
     * Runtime: 309 ms, faster than 22.91% of Java online submissions for 3Sum.
     * Memory Usage: 43.7 MB, less than 29.88% of Java online submissions for 3Sum.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        Set<List<Integer>> result = new HashSet();
        // adding this first level loop duplication check reduces timecost from 1413ms to 309ms
        Set<Integer> dups = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (dups.contains(nums[i])) {
                continue;
            }

            dups.add(nums[i]);
            twoSum3(nums, i, result);
        }

        return new ArrayList(result);
    }

    private void twoSum3(int[] nums, int i, Set<List<Integer>> result) {
        Set<Integer> set = new HashSet();
        int target = -nums[i];
        for (int j = i + 1; j < nums.length; j++) {
            if (set.contains(target - nums[j])) {
                // use set to remove the duplication of list. need to sort first.
                List<Integer> triplet = Arrays.asList(nums[i], nums[j], target - nums[j]);
                Collections.sort(triplet);
                result.add(triplet);
            }
            set.add(nums[j]);
        }
    }

}
