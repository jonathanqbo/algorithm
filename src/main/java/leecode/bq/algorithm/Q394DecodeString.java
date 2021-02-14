package leecode.bq.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/12/21 4:52 PM
 */
public class Q394DecodeString {

    /**
     * solution 1: two stacks: one for count, one for str
     * note: in each [] level, it has one decoded str.
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Decode String.
     * Memory Usage: 37.2 MB, less than 66.29% of Java online submissions for Decode String.
     *
     * @param s
     * @return
     */
    public String decodeString2(String s) {
        Deque<StringBuilder> strStack = new LinkedList<>();
        Deque<Integer> countStack = new LinkedList<>();

        int i = 0;
        StringBuilder curStr  = new StringBuilder();
        int count = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                // count for next str
                countStack.push(count);
                // cur str
                strStack.push(curStr);

                count = 0;
                curStr = new StringBuilder();
            } else if (c == ']') {
                // pop one level from stack to calculate new curStr in upper level
                // merge lastStr in stack with curStr * count, and put it back to stack
                // so the lastStr in strStack can always represent the decoded final string in one []
                StringBuilder lastDecodedStr = strStack.pop();
                int amount = countStack.pop();
                for (int j = 0; j < amount; j++) {
                    lastDecodedStr.append(curStr);
                }

                // key: keep one final decoded string as curStr in one [] level
                curStr = lastDecodedStr;
            } else {
                curStr.append(c);
            }

            i++;
        }

        // the level_0 [] decoded string is the final result
        return curStr.toString();
    }

    /**
     * solution 2: recursion
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Decode String.
     * Memory Usage: 36.8 MB, less than 95.23% of Java online submissions for Decode String.
     *
     * @param s
     * @return
     */
    int i = 0;
    public String decodeString(String s) {
        // recursive on every level: str_amount_[]
        StringBuilder curStr = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int amount = c - '0';
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    amount = amount * 10 + s.charAt(i) - '0';
                    i++;
                }

                // skip [
                i++;

                // recursion
                String childDecodedStr = decodeString(s);
                for (int j = 0; j < amount; j++) {
                    curStr.append(childDecodedStr);
                }
            } else if (c == ']') {
                break;
            } else {
                curStr.append(c);
            }

            i++;
        }

        return curStr.toString();
    }

}
