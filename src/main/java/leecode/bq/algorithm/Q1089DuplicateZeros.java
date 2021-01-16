package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/30/20 10:42 PM
 */
public class Q1089DuplicateZeros {

    /**
     *
     * Runtime: 1 ms, faster than 89.24% of Java online submissions for Duplicate Zeros.
     * Memory Usage: 39.3 MB, less than 43.17% of Java online submissions for Duplicate Zeros.
     *
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
        int stepsToMove = 0;
        int lastItemToMove = 0;
        for (int v : arr) {
            // if last item reachs the end
            if (lastItemToMove + stepsToMove >= arr.length) {
                lastItemToMove--;
                break;
            }

            if (v == 0) {
                // edge case: if last is 0, and dont have enough space to duplicate
                // then, don't need to duplicate it and don't ccount as stepsToMove
                if (lastItemToMove + stepsToMove + 1 >= arr.length) {
                    lastItemToMove--;
                    arr[arr.length - 1] = 0;
                    break;
                }

                stepsToMove++;
            }

            lastItemToMove++;
        }

        if (stepsToMove == 0) {
            return;
        }

        for (int j = lastItemToMove; j >= 0; j--) {
            arr[j + stepsToMove] = arr[j];

            if (arr[j] == 0) {
                arr[j + stepsToMove - 1] = arr[j];
                stepsToMove--;
            }
        }
    }

    /**
     * solution 2: without those detail check
     * @param a
     */
    public void duplicateZeros2(int[] a) {
        int lastItemToMove = 0, stepsToMove = 0;

        for (lastItemToMove = 0; stepsToMove + lastItemToMove < a.length; ++lastItemToMove)
            stepsToMove += a[lastItemToMove] == 0 ? 1 : 0;

        for (lastItemToMove = lastItemToMove - 1; stepsToMove > 0; --lastItemToMove) {
            if (lastItemToMove + stepsToMove < a.length)
                a[lastItemToMove + stepsToMove] = a[lastItemToMove];
            if (a[lastItemToMove] == 0)
                a[lastItemToMove + --stepsToMove] = a[lastItemToMove];
        }
    }

}
