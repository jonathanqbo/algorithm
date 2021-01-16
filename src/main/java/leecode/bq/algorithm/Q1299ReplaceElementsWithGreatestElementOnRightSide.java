package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/31/20 10:40 AM
 */
public class Q1299ReplaceElementsWithGreatestElementOnRightSide {

    /**
     * Runtime: 1 ms, faster than 99.86% of Java online submissions for Replace Elements with Greatest Element on Right Side.
     * Memory Usage: 40.4 MB, less than 52.96% of Java online submissions for Replace Elements with Greatest Element on Right Side.
     *
     * @param arr
     * @return
     */
    public int[] replaceElements(int[] arr) {
        int max = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(tmp, max);
        }

        arr[arr.length - 1] = -1;

        return arr;
    }

}
