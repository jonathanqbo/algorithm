package bq.algorithm.binarysearch;

public class Search2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0)
			return false;
		
		int start = 0, end = matrix.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start)/2;
			
			if (matrix[mid][0] < target) {
				start = mid;
			}
			else if (matrix[mid][0] > target) {
				end = mid;
			}
			else {
				return true;
			}
		}
		
		int row = 0;
		if (matrix[start][0] > target) {
			return false;
		}
		else if (matrix[end][0] < target) {
			row = end;
		}
		else {
			row = start;
		}
		
		start = 0;
		end = matrix[row].length - 1;
		
		while (start  + 1 < end) {
			int mid = start + (end - start)/2;
			
			if (matrix[row][mid] < target) {
				start = mid;
			}
			else if (matrix[row][mid] > target) {
				end = mid;
			}
			else {
				return true;
			}
		}
		
		if (matrix[row][start] == target || matrix[row][end] == target) {
			return true;
		}
		
		return false;
	
	}
	
}
