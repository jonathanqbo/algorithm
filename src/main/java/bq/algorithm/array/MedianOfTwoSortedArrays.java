package bq.algorithm.array;

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] A, int[] B) {
		int length = A.length + B.length;
		
		if (length % 2 == 0) {
			return findKth(A, B, length / 2);
		}
		else {
			return (findKth(A, B, length / 2) + findKth(A, B, length / 2 + 1)) / 2.0;
		}
	}

	private int findKth(int[] a, int[] b, int k) {
		return findKth(a, 0, b, 0, k);
	}

	private int findKth(int[] a, int startA, int[] b, int startB, int k) {
		if (startA >= a.length) {
			return b[startB + k];
		}
		if (startB >= b.length) {
			return a[startA + k];
		}
		if (k == 1) {
			return Math.min(a[startA], b[startB]);
		}
		
		int midA = (startA + k/2 >= a.length) ? Integer.MAX_VALUE : a[startA + k/2];
		int midB = (startB + k/2 >= b.length) ? Integer.MAX_VALUE : b[startB + k/2];
		if (midA < midB) {
			return findKth(a, startA + k/2, b, startB, k - k/2);
		}
		else {
			return findKth(a, startA, b, startB + k/2, k - k/2);
		}
		
	}
}
