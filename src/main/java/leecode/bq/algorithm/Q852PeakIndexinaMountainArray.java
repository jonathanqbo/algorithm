package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/16/21 5:30 PM
 */
public class Q852PeakIndexinaMountainArray {

    /**
     * solution 1: one-pass
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
     * Memory Usage: 38.9 MB, less than 95.44% of Java online submissions for Peak Index in a Mountain Array.
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int i = 0;
        while (i < arr.length && arr[i] < arr[i + 1]) {
            i++;
        }

        return i;
    }

    /**
     * solution 2: binary search
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
     * Memory Usage: 39.7 MB, less than 20.41% of Java online submissions for Peak Index in a Mountain Array.
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray2(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

}
