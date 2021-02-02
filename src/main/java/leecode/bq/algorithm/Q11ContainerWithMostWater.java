package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/22/21 10:01 PM
 */
public class Q11ContainerWithMostWater {

    /**
     * solution 1: brute force
     *
     * Runtime: 642 ms, faster than 18.94% of Java online submissions for Container With Most Water.
     * Memory Usage: 40.1 MB, less than 94.59% of Java online submissions for Container With Most Water.
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                result = Math.max(result, area);
            }
        }

        return result;
    }


    /**
     * solution: two pointers
     *
     * key: the max area always takes the longest and highest bar.
     *
     * Runtime: 2 ms, faster than 95.66% of Java online submissions for Container With Most Water.
     * Memory Usage: 40.5 MB, less than 54.32% of Java online submissions for Container With Most Water.
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[right], height[left]);
            result = Math.max(result, area);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
