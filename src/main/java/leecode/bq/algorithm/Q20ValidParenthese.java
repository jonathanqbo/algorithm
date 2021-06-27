package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 *
 * Example 1:
 *
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/22/20 9:08 PM
 */
public class Q20ValidParenthese {

    /**

     solution: use stack with pairs Map

     if not close char, put into stack; if close char, pop into stack. finally check if stack is empty

     */
    class Solution {

        private Map<Character, Character> closeToOpen = Map.of(']', '[', '}', '{', ')', '(');

        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // key: also push to stack when stack.isEmpty
                if (!closeToOpen.containsKey(c) || stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                // note: convinent way to do pop() and check
                if (stack.pop() != closeToOpen.get(c)) {
                    return false;
                }
            }

            // key: might close brackets left
            return stack.isEmpty();
        }

    }

}
