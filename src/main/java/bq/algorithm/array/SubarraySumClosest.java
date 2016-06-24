package bq.algorithm.array;

import java.util.Arrays;

public class SubarraySumClosest {

	public int[] subarraySumClosest(int[] nums) {
		if (nums == null) {
			return new int[]{};
		}
		
		Subsum[] subsums = new Subsum[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
			subsums[i] = new Subsum(i, sum);
		}
		
		Arrays.sort(subsums);
		
		int[] result = new int[2];
		int minDiff = Integer.MAX_VALUE;
		for(int i = 1; i < subsums.length; i++) {
			int diff = subsums[i].value - subsums[i-1].value;
			if (diff < minDiff) {
				minDiff = diff;
				result[0] = subsums[i-1].index;
				result[1] = subsums[i].index;
			}
		}
		
		return result;
	}
	
	class Subsum implements Comparable<Subsum>{
		int index;
		int value;
		
		public Subsum(int index, int value) {
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(Subsum target) {
			return Integer.compare(this.value, target.value);
		}
	}
	
}
