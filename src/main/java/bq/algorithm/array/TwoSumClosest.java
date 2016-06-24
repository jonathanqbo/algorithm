package bq.algorithm.array;

import java.util.Arrays;

public class TwoSumClosest {

	public int twoSumCloset(int[] nums, int target) {
		if (nums == null || nums.length < 2) {
			return -1;
		}
		
		Arrays.sort(nums);
		
		int start = 0, end = nums.length - 1;
		int minDiff = Integer.MAX_VALUE;
		while (start < end) {
			int sum = nums[start] + nums[end];
			minDiff = Math.min(minDiff, Math.abs(target - sum));

			if (sum < target) {
				start++;
			}
			else {
				end--;
			}
		}
		
		return minDiff;
	}

}
