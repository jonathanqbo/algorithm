package leecode.bq.algorithm;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/16/21 3:44 PM
 */
public class Q56MergeIntervals {

    /**
     * solution: sort
     *
     * Runtime: 5 ms, faster than 94.78% of Java online submissions for Merge Intervals.
     * Memory Usage: 41.7 MB, less than 55.95% of Java online submissions for Merge Intervals.
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval: intervals) {
            int[] lastInterval = merged.peekLast();
            if (lastInterval == null || lastInterval[1] < interval[0]) {
                merged.add(interval);
            } else {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

}
