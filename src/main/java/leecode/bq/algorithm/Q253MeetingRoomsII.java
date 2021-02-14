package leecode.bq.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/6/21 10:01 PM
 */
public class Q253MeetingRoomsII {

    /**
     * solution: sort start time and end time separately, then two pointers checking starts and end time
     *
     * Runtime: 3 ms, faster than 86.21% of Java online submissions for Meeting Rooms II.
     * Memory Usage: 42.1 MB, less than 14.44% of Java online submissions for Meeting Rooms II.
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int p1 = 0, p2 = 0;
        int rooms = 0; // the max rooms needed,
        while (p1 < starts.length) {
            // if one meeting don't need new rooms
            if (starts[p1] >= ends[p2]) {
                rooms--;
                p2++;
            }

            rooms++;
            p1++;
        }

        return rooms;
    }

    /**
     * similar with solution 1
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms2(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int p1 = 0, p2 = 0;
        int rooms = 0; // room amount in current time
        int result = -1;
        while (p1 < starts.length) {
            if (starts[p1] < ends[p2]) {
                rooms++;
                p1++;
                result = Math.max(result, rooms);
            } else {
                rooms--;
                p2++;
            }
        }

        return result;
    }

    /**
     * solution 3: sort start time, then use PriorityQueue for end time, check each start time with the min-end-time
     * in PriorityQueue
     *
     * Runtime: 19 ms, faster than 5.77% of Java online submissions for Meeting Rooms II.
     * Memory Usage: 42.7 MB, less than 5.32% of Java online submissions for Meeting Rooms II.
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms3(int[][] intervals) {
        Arrays.sort(intervals, (t1, t2) -> Integer.compare(t1[0], t2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval: intervals) {
            // if start hour is >= min-end hour
            // wont increase the result rooms amount by remove the min end hour in pq
            if (!pq.isEmpty() && interval[0] >= pq.peek()) {
                pq.poll();
            }

            pq.offer(interval[1]);
        }

        return pq.size();
    }

}
