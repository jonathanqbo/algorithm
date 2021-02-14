package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/2/21 11:16 PM
 */
public class Q849MaximizeDistanceToClosestPerson {

    /**
     * solution: find the max distance between two 1
     *
     * Note: need to handle the start and end cases.
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximize Distance to Closest Person.
     * Memory Usage: 41.7 MB, less than 18.95% of Java online submissions for Maximize Distance to Closest Person.
     *
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {
        int max = 0;

        int i = 0;
        while (i < seats.length && seats[i] != 1) {
            i++;
        }
        max = i;

        int j = seats.length - 1;
        while (j >= 0 && seats[j] != 1 ) {
            j--;
        }
        max = Math.max(max, seats.length - j - 1);

        int pre = i;
        for (int k = i + 1; k <= j; k++) {
            if (seats[k] == 1) {
                max = Math.max(max, (k - pre) / 2);
                pre = k;
            }
        }

        return max;
    }

}
