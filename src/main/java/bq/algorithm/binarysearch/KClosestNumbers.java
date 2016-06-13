package bq.algorithm.binarysearch;

public class KClosestNumbers {
	
	public int[] kClosestNumbers(int[] A, int target, int k) {
		if (A == null || A.length == 0 ) {
			return null;
		}
		
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if ( A[mid] >= target ) {
				end = mid;
			}
			else {
				start = mid;
			}
		}
		
		int[] result = new int[k];
		for ( int i = 0; i < k; i++ ) {
			if ( start >= 0 && Math.abs(A[start] - target) <= Math.abs(A[end] - target)) {
				result[i] = A[start];
				start--;
			}
			else if (end < A.length && Math.abs(A[start] - target) < Math.abs(A[end] - target)){
				result[i] = A[end];
				end++;
			}
			else if ( start < 0 && end < A.length ) {
				result[i] = A[end];
				start--;
			}
			else if ( start >=0 && end >= A.length ) {
				result[i] = A[start];
				end++;
			}
		}
		
		return result;
	
	}

}
