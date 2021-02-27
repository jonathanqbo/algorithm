package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/24/21 9:38 PM
 */
public class Q939MinimumAreaRectangle {

    public int minAreaRect(int[][] points) {
        // group points by x
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            map.putIfAbsent(p[0], new HashSet<>());
            map.get(p[0]).add(p[1]);
        }

        int min = Integer.MAX_VALUE;
        // for each [left-top, right-bottom] points combination
        // calculate the min area
        for (int i = 0; i < points.length; i++) {
            int[] p1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];

                // ignore points that not able to form a rectangle
                if (p1[0] == p2[0] || p1[1] == p2[1]) {
                    continue;
                }

                // from points left-top and right-bottom, get other two points
                if (map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
                    min = Math.min(min, Math.abs((p1[0] - p2[0]) * (p1[1] - p2[1])));
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
