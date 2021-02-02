package leecode.bq.algorithm;

import java.util.LinkedList;

/**
 * <b> </b>
 *
 * solution 1: stack of [value, minvalue] pair
 *
 * solution 2: two stack
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/17/21 10:19 PM
 */
public class Q155MinStack {

    /**
     * Runtime: 4 ms, faster than 94.42% of Java online submissions for Min Stack.
     * Memory Usage: 40.5 MB, less than 82.77% of Java online submissions for Min Stack.
     */
    class Solution {
        // use int[] instead of Integer[]
        private LinkedList<int[]> stack = new LinkedList();

        /** initialize your data structure here. */
        public Solution() {

        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(new int[]{x, x});
                return;
            }

            stack.push(new int[] {x, Math.min(stack.peek()[1], x)});
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            // question doesn't mention how to handle edge cases
            return stack.peek()[0];
        }

        public int getMin() {
            // question doesn't mention how to handle edge cases
            return stack.peek()[1];
        }
    }

    /**
     * solution 2: two stack
     *
     * Runtime: 6 ms, faster than 26.30% of Java online submissions for Min Stack.
     * Memory Usage: 45.7 MB, less than 6.56% of Java online submissions for Min Stack.
     *
     */
    class Solution2 {
        private LinkedList<Integer> values = new LinkedList();
        private LinkedList<Integer> mins = new LinkedList();

        /** initialize your data structure here. */
        public Solution2() {

        }

        public void push(int x) {
            values.push(x);

            if (mins.isEmpty() || x <= mins.peek()) {
                mins.push(x);
            }
        }

        public void pop() {
            Integer x = values.pop();
            if (x.equals(mins.peek())) {
                mins.pop();
            }
        }

        public int top() {
            return values.peek();
        }

        public int getMin() {
            return mins.peek();
        }
    }

}
