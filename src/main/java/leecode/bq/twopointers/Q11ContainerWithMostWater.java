package leecode.bq.twopointers;

/**
 * <b> </b>
 * <p>
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
 * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 * <p>
 * Notice that you may not slant the container.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/22/21 10:01 PM
 */
public class Q11ContainerWithMostWater {

    /**
     solution: two pointers from start/end to center: start --> <-- end

     KEY:
     if height[left] < height[right], then the only possible max is to move left++
     if height[left] > height[right], then the only possible max is to move right--
     if height[left] = height[right], then it doesn't matter move which side


     @see 42: https://leetcode.com/problems/trapping-rain-water/

     */
    class Solution {

        public int maxArea(int[] height) {
            int left = 0, right = height.length - 1;

            int result = 0;
            while (left < right) {
                result = Math.max(result, Math.min(height[left], height[right]) * (right - left));

                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            return result;
        }

    }

}
