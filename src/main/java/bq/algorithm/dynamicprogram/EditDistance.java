package bq.algorithm.dynamicprogram;

public class EditDistance {

	public int minDistance(String word1, String word2) {
		
		int m = word1.length();
		int n = word2.length();
		
		int[][] f = new int[m][n];
		
		
		// f[i][j] = f[i-1][j-1] , if word1[i] = word2[j]
		//         = min( f[i-1][j] + 1, f[i][j-1] + 1, f[i-1][j-1] + 1), if word1[i] != word2[j]
		for ( int i = 0; i <= m; i++ ) {
			f[i][0] = i;
		}
		for ( int i = 0; i <= n; i++ ) {
			f[0][i] = i;
		}
		
		for ( int i = 1; i <= m; i++ ) {
			for ( int j = 1; j <= n; j++) {
				if ( word1.charAt(i - 1) == word2.charAt( j - 1 ) ) {
					f[i][j] = f[i-1][j-1];
				}
				else {
					f[i][j] = Math.min( Math.min(f[i-1][j-1] + 1, f[i-1][j] + 1), f[i][j-1] + 1);
				}
			}
		}
		
		return f[m][n];
		
	}
	
}
