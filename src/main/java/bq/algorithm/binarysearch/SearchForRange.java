package bq.algorithm.binarysearch;

public class SearchForRange {

	public int[] searchRange(int[] A, int target) {
		int[] bound = {-1, -1};
		if (A == null || A.length == 0) {
			return bound;
		}
		
		// left bound
		int start = 0, end = A.length - 1;
		while ( start + 1 < end) {
			int mid = start + (end - start)/2;
			if (A[mid] == target) {
				end = mid;
			}
			else if ( A[mid] < target) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		
		if ( A[start] == target) {
			bound[0] = start;
		}
		else if ( A[end] == target) {
			bound[0] = end;
		}
		else {
			return new int[]{-1, -1};
		}
			
		// right bound
		start = 0;
		end = A.length - 1;
		while ( start + 1 < end) {
			int mid = start + (end - start)/2;
			if (A[mid] == target) {
				start = mid;
			}
			else if ( A[mid] < target) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		
		if ( A[start] == target) {
			bound[1] = start;
		}
		else if ( A[end] == target) {
			bound[1] = end;
		}
		else {
			bound[1] = bound[0];
		}
		
		return bound;
	
	}
	
}
