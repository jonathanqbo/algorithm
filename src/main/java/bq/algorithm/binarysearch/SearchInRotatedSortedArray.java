package bq.algorithm.binarysearch;

public class SearchInRotatedSortedArray {

	public int search(int[] A, int target) {
		if ( A == null || A.length == 0 ) {
			return -1;
		}
		
		int start = 0, end = A.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start)/2;
			
			if ( A[mid] == target) {
				return mid;
			}
			
			if (target <= A[A.length - 1]) {
				if ( A[mid] < target ) {
					start = mid;
				}
				else {
					end = mid;
				}
			}
			else {
				if ( A[mid] > target ) {
					end = mid;
				}
				else {
					start = mid;
				}
			}
		}
		
		if ( A[start] == target) {
			return start;
		}
		if ( A[end] == target) {
			return end;
		}
		
		return -1;
	
	}
	
}
