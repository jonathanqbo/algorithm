package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/4/21 9:24 PM
 */
public class Q702SearchInASortedArrayOfUnknownSize {

    /**
     * solution 1: key is use right = right * 2 to get the boundary for binary loop
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Search in a Sorted Array of Unknown Size.
     * Memory Usage: 40.2 MB, less than 32.31% of Java online submissions for Search in a Sorted Array of Unknown Size.
     *
     * @param reader
     * @param target
     * @return
     */
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 1;
        while (reader.get(right) != 2147483647) {
            right = right * 2;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public int search2(ArrayReader reader, int target) {
        int left = 0, right = 1;
        while (reader.get(right) != 2147483647) {
            // a little improve than solution 1.
            right = right << 1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = reader.get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    /* provided */
    class ArrayReader {

        public int get(int mid) {
            return -1;
        }
    }

}
