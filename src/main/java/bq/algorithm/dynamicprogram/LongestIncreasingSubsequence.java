package bq.algorithm.dynamicprogram;

public class LongestIncreasingSubsequence {

	public int longestIncreasingSubsequence(int[] nums) {
		if ( nums == null || nums.length == 0 ) {
			return 0;
		}
		
		int[] f = new int[nums.length];
		for (int i = 0; i < nums.length; i++ ) {
			f[0] = Integer.MIN_VALUE;
		}
		
		f[0] = 1;
		for ( int i = 1; i < nums.length; i++ ) {
			for ( int j = 0; j < i; j++ ) {
				if ( nums[j] < nums[i] && ( f[j] + 1 > f[i] ) ) {
					f[i] = f[j] + 1;
				}
			}
		}
		
		return f[nums.length - 1];
	}
	
}
