package leecode.bq.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/1/21 9:48 PM
 */
public class Q681NextClosestTime {

    /**
     * solution 1: check all permutation
     *
     * Runtime: 10 ms, faster than 25.16% of Java online submissions for Next Closest Time.
     * Memory Usage: 37.7 MB, less than 56.49% of Java online submissions for Next Closest Time.
     *
     * @param time
     * @return
     */
    public String nextClosestTime(String time) {
        int h1 = time.charAt(0) - '0';
        int h2 = time.charAt(1) - '0';
        int m1 = time.charAt(3) - '0';
        int m2 = time.charAt(4) - '0';

        int startTime = (h1 * 10 + h2) * 60 + m1 * 10 + m2;

        Set<Integer> allowed = new HashSet();
        allowed.add(h1);
        allowed.add(h2);
        allowed.add(m1);
        allowed.add(m2);

        int nextTime = 0;
        int oneDay = 24 * 60;
        int minTimeElapsed = Integer.MAX_VALUE;
        for (Integer h1i : allowed) {
            if (h1i > 2) {
                continue;
            }

            for (Integer h2i : allowed) {
                if (h1i * 10 + h2i > 23) {
                    continue;
                }

                for (Integer m1i : allowed) {
                    if (m1i > 5) {
                        continue;
                    }

                    for (Integer m2i: allowed) {
                        int curTime = (h1i * 10 + h2i) * 60 + m1i * 10 + m2i;
                        int diff = curTime - startTime;
                        diff = diff > 0 ? diff : diff + oneDay;
                        if (diff < minTimeElapsed) {
                            minTimeElapsed = diff;
                            nextTime = curTime;
                        }
                    }
                }
            }
        }

        return String.format("%02d:%02d", nextTime / 60, nextTime % 60);
    }

}
