package bq.algorithm.dynamicprogram;

public class LongestCommonSubsequence {

	public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if ( A == null || B == null ) {
			return 0;
		}
		
		int m = A.length();
		int n = B.length();
		
		int[][] f = new int[m+1][n+1];
		
		for ( int i = 0; i < m; i++ ) {
			f[i][0] = 0;
		}
		for ( int i = 0; i < n; i++ ) {
			f[0][i] = 0;
		}
		
		for ( int i = 1; i <= m; i++ ) {
			for ( int j = 1; j <= n; j++ ) {
				if ( A.charAt(i-1) == B.charAt(j-1) ) {
					f[i][j] = Math.max(f[i-1][j-1] + 1, Math.max(f[i-1][j], f[i][j-1]));
				}
				else {
					f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
				}
			}
		}
		
		return f[m][n];
    }
	
}
