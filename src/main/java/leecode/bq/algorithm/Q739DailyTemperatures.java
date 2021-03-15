package leecode.bq.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/6/21 11:38 PM
 */
public class Q739DailyTemperatures {

    /**
     * solution 1: Stack from left to right
     *
     * Runtime: 18 ms, faster than 39.50% of Java online submissions for Daily Temperatures.
     * Memory Usage: 85.5 MB, less than 5.01% of Java online submissions for Daily Temperatures.
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peekLast()] < T[i]) {
                int idx = stack.pollLast();
                result[idx] = i - idx;
            }

            stack.offerLast(i);
        }

        return result;
    }

    /**
     * solution 3: same as solution 1, but use array+top as stack
     *
     * Runtime: 5 ms, faster than 95.57% of Java online submissions for Daily Temperatures.
     * Memory Usage: 75.9 MB, less than 13.77% of Java online submissions for Daily Temperatures.
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures3(int[] T) {
        int[] result = new int[T.length];

        // use array as stack
        int[] stack = new int[T.length];
        int top = -1;

        for (int i = 0; i < T.length; i++) {
            while (top >= 0 && T[stack[top]] < T[i]) {
                int idx = stack[top--];
                result[idx] = i - idx;
            }

            stack[++top] = i;
        }

        return result;
    }

    /**
     * solution 2: stack from right to left
     *
     * Runtime: 22 ms, faster than 31.99% of Java online submissions for Daily Temperatures.
     * Memory Usage: 85.6 MB, less than 5.01% of Java online submissions for Daily Temperatures.
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures2(int[] T) {
        int[] result = new int[T.length];

        Deque<Integer> stack = new LinkedList<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peekLast()] <= T[i]) {
                stack.pollLast();
            }

            result[i] = stack.isEmpty() ? 0 : stack.peekLast() - i;

            stack.offerLast(i);
        }

        return result;
    }

}
