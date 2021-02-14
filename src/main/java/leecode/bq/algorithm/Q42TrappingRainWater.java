package leecode.bq.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/4/21 10:50 PM
 */
public class Q42TrappingRainWater {

    /**
     * solution 1: two pointers
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Trapping Rain Water.
     * Memory Usage: 38.8 MB, less than 44.48% of Java online submissions for Trapping Rain Water.
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    result += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    result += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }

        return result;
    }

    /**
     * solution 2: stack
     *
     * Runtime: 2 ms, faster than 28.68% of Java online submissions for Trapping Rain Water.
     * Memory Usage: 38.8 MB, less than 44.48% of Java online submissions for Trapping Rain Water.
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int result = 0;

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int i = 1;
        while (i < height.length) {
            while (height[i] > height[stack.peek()]) {
                int j = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int left = stack.peek();
                result += (Math.min(height[i], height[left]) - height[j]) * (i - left - 1);
            }

            stack.push(i);
            i++;
        }

        return result;
    }

}
