package leecode.bq.algorithm;

import java.util.LinkedList;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/16/21 5:06 PM
 */
public class Q57InsertInterval {

    /**
     * solution: one loop
     *
     * Runtime: 1 ms, faster than 98.83% of Java online submissions for Insert Interval.
     * Memory Usage: 41.5 MB, less than 43.47% of Java online submissions for Insert Interval.
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> result = new LinkedList<>();

        // leftside outside
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // overlap
        result.add(newInterval);
        int[] lastInterval = newInterval;
        while (i < intervals.length && intervals[i][0] <= lastInterval[1]) {
            lastInterval[0] = Math.min(intervals[i][0], lastInterval[0]);
            lastInterval[1] = Math.max(intervals[i][1], lastInterval[1]);
            i++;
        }

        // rightside outside
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

}
