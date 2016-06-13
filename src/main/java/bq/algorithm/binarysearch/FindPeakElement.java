package bq.algorithm.binarysearch;

public class FindPeakElement {
	
	public int findPeak(int[] A) {
		if ( A == null || A.length == 0 ) {
			return -1;
		}
		
		int start = 0, end = A.length - 1;
		while ( start + 1 < end ) {
			int mid = start + ( end - start ) / 2;
			
			if ( A[mid] < A[mid + 1] ) {
				start = mid;
			}
			else if ( A[mid] > A[mid + 1] ) {
				end = mid;
			}
			else {
				// impossible to run into this case
			}
		}
		
		return Math.max(A[start], A[end]);
	}
	
}
