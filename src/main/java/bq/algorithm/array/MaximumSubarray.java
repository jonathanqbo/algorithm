package bq.algorithm.array;

public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
		int sum = 0;
		int min = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			max = Math.max(max, sum - min);
			min = Math.min(min, sum);
		}
		
		return max;
	}
	
}
