package bq.algorithm.dynamicprogram;

public class PalindromePartitioning {

	public int minCut(String s) {
        int m  = s.length();
        
        int[] f = new int[m];
        
        f[0] = 0;
        
        for ( int i = 1; i <= m; i++ ) {
        	int minCut = -1;
        	for ( int j = i-1; j >= 0; j-- ) {
        		if ( isPalindrome(s.substring(i, i)) ) {
        			minCut = Math.min(f[j] + 1, minCut);
        		}
        		else {
        			minCut = Math.min(f[j], minCut);
        		}
        	}
        }
        
        return f[m];
    }
	
	private boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		
		while ( start < end ) {
			if ( s.charAt(start) != s.charAt(end) ) {
				return false;
			}
			
			start++;
			end--;
		}
		
		return true;
	}
	
}
