package bq.algorithm.array;

public class MergeSortedArray {

	
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
		// implementation key: from back to front to avoid move all the following array element for each merge
		int end = m + n - 1;
		int endA = m - 1;
		int endB = n - 1;
		
		while (endA >= 0 && endB >= 0) {
			if (A[endA] > B[endB]) {
				A[end] = A[endA];
				endA--;
			}
			else {
				A[end] = B[endB];
				endB--;
			}
			end--;
		}
		
		while (endB >= 0) {
			A[end] = B[endB];
			endB--;
		}
	}
	
}
