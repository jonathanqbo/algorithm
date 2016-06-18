package bq.algorithm.dynamicprogram;

public class DistinctSubsequence {

	public int numDistinct(String S, String T) {
		
		int m = T.length();
		int n = S.length();
		
		int[][] f = new int[m+1][n+1];
		
		for ( int i = 0; i <= m; i++ ) {
			f[i][0] = 0; 
		}
		for ( int i = 0; i <= n; i++ ) {
			f[0][i] = 1;
		}
		
		for ( int i = 1; i <= m; i++ ) {
			for ( int j = 1; j <= n; j++ ) {
				if ( T.charAt(i - 1) == S.charAt(j - 1) ) {
					f[i][j] = f[i][j-1] + f[i-1][j-1];
				}
				else {
					f[i][j] = f[i-1][j-1];
				}
			}
		}
		
		return f[m][n];
	}
	
}
