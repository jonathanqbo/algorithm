package bq.algorithm.binarysearch;

public class SearchInBigSortedArray {

	public int searchBigSortedArray(ArrayReader reader, int target) {
		int start = 0, end = 1;
		
		int value = reader.get(end);
		while (value < target && value != -1) {
			end = end*2;
		}
		
		while ( start + 1 < end) {
			int mid = start + (end - start)/2;

			int midValue = reader.get(mid);
			if (midValue == -1) {
				end = mid;
			}
			else if (midValue < target) {
				start = midValue;
			}
			else if(midValue > target) {
				end = midValue;
			}
			else {
				end = midValue;
			}
		}
		
		value = reader.get(start);
		if (value == target) {
			return start;
		}
		else if ( value == target) {
			return end;
		}
		
		return -1;
	}
	
}

class ArrayReader {

	public int get(int index) {
		return -1;
	}
	
}