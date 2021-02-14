package leecode.bq.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/7/21 10:32 AM
 */
public class Q844BackspaceStringCompare {

    /**
     * solution 1: stack
     *
     * Runtime: 1 ms, faster than 68.67% of Java online submissions for Backspace String Compare.
     * Memory Usage: 37.6 MB, less than 29.90% of Java online submissions for Backspace String Compare.
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        Deque<Character> s1 = build(S);
        Deque<Character> s2 = build(T);

        if (s1.size() != s2.size()) {
            return false;
        }

        // pretty same performance with using iterator
        // but note: toString() has redundent ==> "[f]"
        return s1.toString().equals(s2.toString());

//         Iterator<Character> it1 = s1.iterator();
//         Iterator<Character> it2 = s2.iterator();
//         while (it1.hasNext()) {
//             if (!it1.next().equals(it2.next())) {
//                 return false;
//             }
//         }

//         return true;
    }

    private Deque<Character> build(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        return stack;
    }

    /**
     * solution 2: two pointers from right to left
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Backspace String Compare.
     * Memory Usage: 37 MB, less than 86.57% of Java online submissions for Backspace String Compare.
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare2(String S, String T) {
        int ps = S.length() - 1;
        int pt = T.length() - 1;

        // or
        while (ps >= 0 || pt >= 0) {
            int skip = 0;

            while (ps >= 0) {
                // key: the use of skip to handle cases: ## ### #### ...
                if (S.charAt(ps) == '#') {
                    skip++;
                    ps--;
                } else if (skip > 0) {
                    skip--;
                    ps--;
                } else {
                    break;
                }
            }

            skip = 0;
            while (pt >= 0) {
                if (T.charAt(pt) == '#') {
                    skip++;
                    pt--;
                } else if (skip > 0) {
                    skip--;
                    pt--;
                } else {
                    break;
                }
            }

            if (pt >=0 && ps >= 0 && S.charAt(ps) != T.charAt(pt)) {
                return false;
            }

            // key: if any of S T reach to end, stop
            if ((pt >= 0) != (ps >= 0)) {
                return false;
            }

            pt--;
            ps--;
        }

        // if (ps >= 0 || pt >= 0) {
        //     return false;
        // }

        return true;
    }

}
