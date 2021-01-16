package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/1/21 3:59 PM
 */
public class Q278FirstBadVersion {

    /**
     * note: small modification to standard binary search.
     * right = mid, instead of: right = mid - 1;  since we want to keep the first bad version.
     *
     * Runtime: 12 ms, faster than 98.12% of Java online submissions for First Bad Version.
     * Memory Usage: 35.6 MB, less than 67.61% of Java online submissions for First Bad Version.
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // right is the first bad version
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    /* provided function */
    private boolean isBadVersion(int version) {
        return true;
    }

}
