package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/22/20 9:08 PM
 */
public class Q20ValidParenthese {

    private Map<Character, Character> mappings = new HashMap();

    public Q20ValidParenthese() {
        mappings.put('[', ']');
        mappings.put('(', ')');
        mappings.put('{', '}');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c))
                stack.push(c);
            else {
                if (stack.empty())
                    return false;

                char c2 = stack.pop();
                if (mappings.get(c2) != c)
                    return false;
            }
        }

        return stack.isEmpty();
    }

}
