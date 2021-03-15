package leecode.bq.algorithm;

import java.util.Arrays;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/11/21 10:31 AM
 */
public class Q1465MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts {

    /**
     * solution: find max_horizontal_cut_width and max_vertical_cut_width
     *
     * Runtime: 13 ms, faster than 96.12% of Java online submissions for Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts.
     * Memory Usage: 48.9 MB, less than 77.21% of Java online submissions for Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts.
     *
     */
    class Solution {
        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            // original array is not sorted
            Arrays.sort(horizontalCuts);
            Arrays.sort(verticalCuts);

            int maxHorizontalCut = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
            for (int i = 1; i < horizontalCuts.length; i++) {
                maxHorizontalCut = Math.max(maxHorizontalCut, horizontalCuts[i] - horizontalCuts[i - 1]);
            }

            int maxVerticalCut = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
            for (int i = 1; i < verticalCuts.length; i++) {
                maxVerticalCut = Math.max(maxVerticalCut, verticalCuts[i] - verticalCuts[i - 1]);
            }

            // the result is bigger than MAX_INTEGER, use long
            return (int) ((1l * maxHorizontalCut * maxVerticalCut) % (Math.pow(10, 9) + 7));
        }
    }

}
