package bq.algorithm.dynamicprogram;

public class ClimbingStairs {

	public int climbStairs(int n) {
		if ( n == 0 ) {
			return 0;
		}
		
		int[] f = new int[n];
		
		f[0] = 1;
		f[1] = 2;
		
		for ( int i = 2; i < n; i++ ) {
			f[i] = f[i-1] + f[i-2];
		}
		
		return f[n-1];
	}
	
}
