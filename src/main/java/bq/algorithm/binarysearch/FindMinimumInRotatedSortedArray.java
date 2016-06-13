package bq.algorithm.binarysearch;

public class FindMinimumInRotatedSortedArray {

	public int findMin(int[] num) {
		if (num == null || num.length == 0) {
			return -1;
		}
		
		int start = 0, end = num.length - 1;
		while ( start + 1 < end ) {
			int mid = start + ( end - start ) / 2;
			
			if ( num[mid] < num[0]) {
				end = mid;
			}
			else if ( num[mid] > num[0] ) {
				start = mid;
			}
			else {
				// impossible to run into here
			}
		}
		
		return num[start] < num[end] ? start : end;
	}
	
}
