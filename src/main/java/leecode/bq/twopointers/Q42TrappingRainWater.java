package leecode.bq.twopointers;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <b> </b>
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/4/21 10:50 PM
 */
public class Q42TrappingRainWater {

    /**
     solution 1: two pointers

     1. left, right pointer, and keep tracking leftMax and rightMax
     2. if height[left] < height[right], (that means the only possible bar to trap more water is nexts of left), so move left pointer, else move right pointer
     3. then for each bar, accumulate sum: max-height[bar]

     @see 11: https://leetcode.com/problems/container-with-most-water/

     Time complexity: O(n)
     Space complexity: O(1)

     ----------------

     solution 2: stack

     use stack that keep index i
     for each bar:
     while height[i] > height[i-1]:
     cur = i
     top = stack.pop
     left = stack.peek
     sum += (min{left.height, cur.height} - top.height) * (cur - left - 1)

     */
    class Solution {

        public int trap(int[] height) {
            if (height == null || height.length < 3) {
                return 0;
            }

            int left = 0, right = height.length - 1;
            int leftMax = height[left], rightMax = height[right];

            int result = 0;
            while (left <= right) {
                if (leftMax <= rightMax) {
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

    }

}
