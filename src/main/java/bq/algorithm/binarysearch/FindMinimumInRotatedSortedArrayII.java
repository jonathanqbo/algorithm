package bq.algorithm.binarysearch;

public class FindMinimumInRotatedSortedArrayII {

	public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
			return -1;
		}
		
		int start = 0, end = num.length - 1;
		while ( start + 1 < end ) {
			int mid = start + ( end - start ) / 2;
			
			if ( num[mid] < num[end]) {
				end = mid;
			}
			else if ( num[mid] > num[end] ) {
				start = mid;
			}
			else {
				// special here
				end--;
			}
		}
		
		return num[start] < num[end] ? num[start] : num[end];
    }
	
}
