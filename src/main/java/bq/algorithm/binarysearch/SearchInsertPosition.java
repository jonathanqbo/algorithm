package bq.algorithm.binarysearch;

public class SearchInsertPosition {

	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
		if ( target < A[0])
			return 0;
		
		int start = 0;
		int end = A.length - 1;
		
		while (start + 1 < end) {
			int mid = start + (end - start)/2;
			
			if (A[mid] < target) {
				start = mid;
			}
			else if (A[mid] == target) {
				return mid - 1;
			}
			else {
				end = mid;
			}
		}
		
		if (A[start] == target) {
			return start - 1;
		}
		else
			return start;
		
	}
	
	
}
