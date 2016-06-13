package bq.algorithm.binarysearch;

public class TotalOccurence {

	public int totalOccurrence(int[] A, int target) {
        // Write your code here
		if ( A == null || A.length == 0 ) {
			return 0;
		}
		
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] >= target) {
				end = mid;
			}
			else {
				start = mid;
			}
		}
		
		int first = start;
		if (A[start] == target) {
			first = start;
		}
		else if ( A[end] == target ) {
			first = end;
		}
		else {
			return 0;
		}
		
		start = first;
		end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if ( A[mid] <= target ) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		
		int last = end;
		if( A[last] == target ) {
			last = end;
		}
		else if (A[start] == target) {
			last = start;
		}
		else {
			// Impossible to run into this case
		}
		
		return last - first + 1;
    }
	
}
