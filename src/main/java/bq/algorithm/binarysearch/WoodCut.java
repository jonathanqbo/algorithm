package bq.algorithm.binarysearch;

public class WoodCut {

	public int woodCut(int[] L, int k) {
		// find the longest wood
		int max = -1;
		for (int i = 0; i < L.length; i++) {
			max = Math.max(max, L[i]);
		}
		
		// binary search on max value
		int start = 0, end = max;
		while ( start + 1 < end ) {
			int mid = start + (end - start) / 2;
			
			// calculate how many woods can be cut
			int count = count(L, mid);
			
			// binary search
			if ( count >= k ) {
				return mid;
			}
			else {
				end = mid;
			}
		}
		
		if (count(L, end) >= k) {
			return end;
		} 
		else if ( count(L,start) >= k) {
			return start;
		}
		
		return -1;
	}
	
	private int count(int[] L, int length) {
		int count = 0;
		for ( int i = 0; i < L.length; i++) {
			count += L[i]/length;
		}
		
		return count;
	}
	
}
