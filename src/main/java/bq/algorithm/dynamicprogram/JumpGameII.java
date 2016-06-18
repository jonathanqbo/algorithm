package bq.algorithm.dynamicprogram;

public class JumpGameII {
	
	public int jump(int[] A) {
		if ( A == null || A.length == 0 ) {
			return -1;
		}
		
		int[] f = new int[A.length];
		for ( int i = 0; i < A.length; i++ ) {
			f[i] = Integer.MAX_VALUE;
		}
		
		f[0] = 0;
		for ( int i = 1; i < A.length; i++ ) {
			for ( int j = i-1; j >= 0; j-- ) {
				if ( f[j] < Integer.MAX_VALUE && (j + A[j] >= i) ) {
					if ( f[j] + 1 < f[i]) {
						f[i] = f[j] + 1;
					}
				}
			}
		}
		
		return f[A.length - 1];
	}
	
}
