package bq.algorithm.dynamicprogram;

public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		if ( s3 == null ) {
			return true;
		}
		if ( s1 == null ) {
			if ( s3.equals(s2) ) {
				return true;
			}
			else {
				return false;
			}
		}
		if ( s2 == null ) {
			if (s3.equals(s1)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		int m = s1.length();
		int n = s2.length();
		
		boolean[][] f = new boolean[m+1][n+1];
		
		f[0][0] = true;
		
		boolean isMatch = true;
		for ( int i = 1; i <= m; i++ ) {
			if ( isMatch ) {
				if ( s3.charAt(i-1) == s1.charAt(i-1) ) {
					f[i][0] = true;
				}
				else {
					isMatch = false;
				}
			}
			else {
				f[i][0] = false;
			}
		}
		isMatch = true;
		for ( int i = 1; i <= n; i++ ) {
			if ( isMatch ) {
				if ( s3.charAt(i-1) == s2.charAt(i-1) ) {
					f[0][i] = true;
				}
				else {
					isMatch = false;
				}
			}
			else {
				f[0][i] = false;
			}
		}
		
		// f[i][j] = f[i-1][j] && s3[i+j-1] == s1[i-1] OR f[i][j-1] && s3[i+j-1] == s2[j-1]
		for ( int i = 1; i <= m; i++ ) {
			for ( int j = 1; j <= n; j++ ) {
				f[i][j] = ( f[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1) ) || ( f[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1) );
			}
		}
		
		return f[m][n];
    }
	
}
