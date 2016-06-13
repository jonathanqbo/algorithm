package bq.algorithm.binarysearch;

public class FirstBadVersion {

	public int findFirstBadVersion(int n) {
		if ( n == 0 ) {
			return -1;
		}
		
		int start = 0, end = n;
		
		while ( start + 1 < end) {
			int mid = start + (end - start)/2;
			
			boolean isBad = SVNRepo.isBadVersion(mid);
			if (isBad) {
				end = mid;
			}
			else {
				start = mid;
			}
		}
		
		if (SVNRepo.isBadVersion(start)) {
			return start;
		}
		else if ( SVNRepo.isBadVersion(end) ) {
			return end;
		}
		else {
			return -1;
		}
	}
	
}

class SVNRepo {
	public static boolean isBadVersion(int k) {
		return false;
	}
}
