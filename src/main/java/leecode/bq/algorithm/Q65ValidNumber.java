package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:46 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */

import java.util.Map;
import java.util.Set;

/**

 solution: State machine

 The KEY is to draw the state transition graph.

 https://leetcode.com/problems/valid-number/discuss/23728/A-simple-solution-in-Python-based-on-DFA

 KEY:
 note: the next state of state 3 ----dot----> state 5.
 bacasue: "3." is valid number, but "." or "+." is not valid number, so there are two separated states.

 */


class Q65ValidNumber {

    public boolean isNumber(String s) {
        String digit = "digit", sign = "sign", dot = "dot", e = "e", end = "end";

        // Map: (fromState, transition, toState)
        Map<Integer, Map<String, Integer>> transitions = Map.of(
                1, Map.of(digit, 3, sign, 2, dot, 4),
                2, Map.of(digit, 3, dot, 4),
                3, Map.of(e, 6, dot, 5, digit, 3),
                4, Map.of(digit, 5),
                5, Map.of(digit, 5, e, 6),
                6, Map.of(sign, 7, digit, 8),
                7, Map.of(digit, 8),
                8, Map.of(digit, 8)
        );

        Set<Integer> validEndState = Set.of(3, 5, 8);

        int curState = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            String transition = null;
            if (c >= '0' && c <= '9') {
                transition = digit;
            } else if (c == '.') {
                transition = dot;
            } else if (c == 'e' || c == 'E') {
                transition = e;
            } else if (c == '+' || c == '-') {
                transition = sign;
            } else {
                // invalid character
                return false;
            }

            if (transitions.get(curState).containsKey(transition)) {
                curState = transitions.get(curState).get(transition);
            } else {
                return false;
            }
        }

        return validEndState.contains(curState);
    }

}


