package bq.algorithm.dynamicprogram;

public class JumpGame {

	public boolean canJump(int[] A) {
		if ( A == null || A.length == 0 ) {
			return false;
		}
		
		boolean[] f = new boolean[A.length];
		
		f[0] = true;
		
		for ( int i = 1; i < A.length; i++ ) {
			for ( int j = i-1; j >= 0; j-- ) {
				if ( f[j] && (A[j] + j >= i) ) {
					f[i] = true;
					break;
				}
			}
		}
		
		return f[A.length - 1];
	}
	
}
