package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/15/21 12:03 AM
 */
public class Q986IntervalListIntersections {

    /**
     * solution: two pointers
     *
     * Runtime: 2 ms, faster than 99.60% of Java online submissions for Interval List Intersections.
     * Memory Usage: 39.8 MB, less than 83.71% of Java online submissions for Interval List Intersections.
     *
     */
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            int p1 = 0;
            int p2 = 0;

            List<int[]> result = new ArrayList<>();
            while (p1 < firstList.length && p2 < secondList.length) {
                int low = Math.max(firstList[p1][0], secondList[p2][0]);
                int high = Math.min(firstList[p1][1], secondList[p2][1]);
                // there is intersection
                if (low <= high) {
                    result.add(new int[] {low, high});
                }

                // KEY: decided on the endpoint instead of startpoint
                if (firstList[p1][1] <= secondList[p2][1]) {
                    p1++;
                } else {
                    p2++;
                }
            }

            return result.toArray(new int[0][]);
        }
    }
}
