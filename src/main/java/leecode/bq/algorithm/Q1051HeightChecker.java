package leecode.bq.algorithm;

import java.util.Arrays;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/31/20 7:39 PM
 */
public class Q1051HeightChecker {

    /**
     * solution: sort and compare
     *
     * Runtime: 1 ms, faster than 79.59% of Java online submissions for Height Checker.
     * Memory Usage: 36.4 MB, less than 93.21% of Java online submissions for Height Checker.
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        // to clone an array:
        // int[] orderedHeights = heights.clone();
        int[] orderedHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(orderedHeights);

        int amount = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != orderedHeights[i]) {
                amount++;
            }
        }

        return amount;
    }

}
