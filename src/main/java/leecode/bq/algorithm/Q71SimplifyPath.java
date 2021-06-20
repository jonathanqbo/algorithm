package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:47 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**

 solution: stack

 .  ignore
 .. stack.pop

 KEY: how to loop stack from bottom up

 */

class Q71SimplifyPath {

    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        String[] parts = path.split("/");
        for (String part : parts) {
            if (part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                // KEY: check if stack is empty inside the .. check
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!part.isEmpty()) { // KEY: check if part is empty!
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            // KEY: stack from bottom up => pollLast()!
            result.append("/").append(stack.pollLast());
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}
