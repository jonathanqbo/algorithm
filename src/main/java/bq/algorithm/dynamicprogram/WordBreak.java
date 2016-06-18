package bq.algorithm.dynamicprogram;

import java.util.Set;

public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {
		
		int m = s.length();
		
		boolean[] f = new boolean[m+1];
		
		int maxLength = -1;
		for(String word : dict) {
			if ( word.length() > maxLength ) {
				maxLength = word.length();
			}
		}
		
		for ( int i = 1; i <= m; i++ ) {
			for ( int j = i - 1; j >= 0 && (i-j <= maxLength ); j-- ) {
				if ( f[j] && dict.contains( s.substring(j, i)) ) {
					f[i] = true;
					break;
				}
			}
		}
		
		return f[m];
	}
	
}
