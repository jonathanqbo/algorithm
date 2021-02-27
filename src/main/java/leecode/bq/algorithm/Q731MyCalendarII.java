package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/22/21 11:22 PM
 */
public class Q731MyCalendarII {

    /**
     * solution: De Morgan's Law + Calculate Overlap
     *
     * Runtime: 59 ms, faster than 78.03% of Java online submissions for My Calendar II.
     * Memory Usage: 40.2 MB, less than 35.06% of Java online submissions for My Calendar II.
     *
     */
    class MyCalendarTwo {

        List<int[]> calendar;
        List<int[]> overlaps;

        MyCalendarTwo() {
            calendar = new ArrayList();
            overlaps = new ArrayList();
        }

        public boolean book(int start, int end) {
            for (int[] iv: overlaps) {
                if (iv[0] < end && start < iv[1]) return false;
            }
            for (int[] iv: calendar) {
                // De Morgan's Law
                if (iv[0] < end && start < iv[1]) {
                    // KEY: only calculate the overlap part
                    overlaps.add(new int[]{Math.max(start, iv[0]), Math.min(end, iv[1])});
                }
            }

            calendar.add(new int[]{start, end});
            return true;
        }
    }

}
