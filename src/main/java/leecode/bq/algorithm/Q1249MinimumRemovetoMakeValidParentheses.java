package leecode.bq.algorithm;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/15/21 12:04 AM
 */
public class Q1249MinimumRemovetoMakeValidParentheses {

    /**
     * solution 1: stack
     *
     * Runtime: 17 ms, faster than 68.48% of Java online submissions for Minimum Remove to Make Valid Parentheses.
     * Memory Usage: 40.2 MB, less than 36.24% of Java online submissions for Minimum Remove to Make Valid Parentheses.
     *
     * @param s
     * @return
     */
    public String minRemoveToMakeValid2(String s) {
        Deque<Integer> stack = new LinkedList<>();
        Set<Integer> toRemoved = new HashSet<>();

        // all invalid ")"
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    toRemoved.add(i);
                }
            }
        }

        // all left "("
        while (!stack.isEmpty()) {
            toRemoved.add(stack.pop());
        }

        // build result
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!toRemoved.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    /**
     * solution 2: optimized two pass
     * second pass only need to remove balanced amount of "(" from rightmost
     *
     * Runtime: 15 ms, faster than 78.97% of Java online submissions for Minimum Remove to Make Valid Parentheses.
     * Memory Usage: 39.3 MB, less than 97.15% of Java online submissions for Minimum Remove to Make Valid Parentheses.
     *
     * @param s
     * @return
     */
    public String minRemoveToMakeValid(String s) {
        // first pass, get rid of all invalid ")"
        StringBuilder sb1 = new StringBuilder();

        int totalOpenBracket = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                balance++;
                totalOpenBracket++;
            } else if (c == ')') {
                if (balance == 0) {
                    continue;
                }
                balance--;
            }

            sb1.append(c);
        }

        // second pass, get rid of balance amount of "(" from rightmost
        StringBuilder sb2 = new StringBuilder();
        int closeBracket = totalOpenBracket - balance;
        for (int i = 0; i < sb1.length(); i++) {
            char c = sb1.charAt(i);
            if (c == '(') {
                if (closeBracket == 0) {
                    continue;
                } else {
                    closeBracket--;
                }

            }
            sb2.append(c);
        }

        return sb2.toString();
    }

    /**
     * solution 3: two pass: left to right, right to left
     *
     *
     * @param s
     * @return
     */
     public String minRemoveToMakeValid3(String s) {
         // first pass, get rid of all invalid ")"
         StringBuilder sb1 = new StringBuilder();

         int balance = 0;
         for (int i = 0; i < s.length(); i++) {
             char c = s.charAt(i);
             if (c == '(') {
                 balance++;
                 sb1.append(c);
             } else if (c == ')') {
                 if (balance >= 1) {
                     balance--;
                     sb1.append(c);
                 }
             } else {
                 sb1.append(c);
             }
         }

         // second pass, get rid of all invalid "("
         StringBuilder sb2 = new StringBuilder();
         balance = 0;
         for (int i = sb1.length() - 1; i >= 0; i--) {
             char c = sb1.charAt(i);
             if (c == ')') {
                 balance++;
                 sb2.append(c);
             } else if (c == '(') {
                 if (balance >= 1) {
                     balance--;
                     sb2.append(c);
                 }
             } else {
                 sb2.append(c);
             }
         }

         return sb2.reverse().toString();
     }

}
