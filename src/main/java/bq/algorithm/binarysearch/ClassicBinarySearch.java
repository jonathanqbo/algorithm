package bq.algorithm.binarysearch;

public class ClassicBinarySearch {

	public int findPosition(int[] nums, int target) {
		if ( nums == null || nums.length == 0 ) {
			return -1;
		}
		
		int start = 0, end = nums.length - 1;
		while ( start + 1 < end ) {
			int mid = start + (end - start) / 2;
			if( nums[mid] == target) {
				return mid;
			}
			else if ( nums[mid] < target) {
				start = mid;
			}
			else {
				end = mid;
			}
		}
		
		if ( nums[start] == target) {
			return start;
		}
		else if ( nums[end] == target ) {
			return end;
		}
		else {
			return -1;
		}
	}
	
}
