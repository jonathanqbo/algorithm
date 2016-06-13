package bq.algorithm.binarysearch;

public class ClosedNumberInSortedArray {

	public int closestNumber(int[] A, int target) {
		if ( A == null || A.length == 0 ) {
			return -1;
		}
		
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			
			if ( A[mid] > target) {
				end = mid;
			}
			else if ( A[mid] == target ) {
				// find any
				return mid;
			}
			else {
				start = mid;
			}
		}
		
		if (A[start] >= target) {
			return start;
		}
		else {
			return end;
		}
    }
	
}
