package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/30/20 11:56 PM
 */
public class Q941ValidMountainArray {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Mountain Array.
     * Memory Usage: 39.7 MB, less than 98.69% of Java online submissions for Valid Mountain Array.
     *
     * @param arr
     * @return
     */
    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3)
            return false;

        int i = 0;
        while (i + 1< arr.length && arr[i] < arr[i + 1]) {
            i++;
        }

        // peak cannot be first and last one
        if (i == 0 || i == arr.length - 1) {
            return false;
        }

        while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == arr.length - 1;
    }

}
