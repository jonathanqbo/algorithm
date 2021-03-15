package leecode.bq.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/11/21 9:27 PM
 */
public class Q772BasicCalculatorIII {

    /**
     * solution: two stacks
     *
     * Runtime: 5 ms, faster than 63.52% of Java online submissions for Basic Calculator III.
     * Memory Usage: 38.8 MB, less than 65.49% of Java online submissions for Basic Calculator III.
     *
     */
    class Solution {

        public int calculate(String s) {
            Deque<Integer> numStack = new LinkedList<>();
            Deque<Character> operatorStack = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isWhitespace(c)) {
                    continue;
                }

                if (Character.isDigit(c)) {
                    int num = c - '0';
                    while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                        num = num*10 + (s.charAt(i + 1) - '0');
                        i++;
                    }

                    numStack.push(num);
                } else if (c == '(') {
                    operatorStack.push(c);
                } else if (c == ')') {
                    while (operatorStack.peek() != '(') {
                        int tmp = doOperation(operatorStack.pop(), numStack.pop(), numStack.isEmpty() ? 0 : numStack.pop());
                        numStack.push(tmp);
                    }
                    operatorStack.pop();
                } else {
                    // KEY: handle cases such as "-2 + 1" or "(-2) + 1"
                    // if ((c == '-') && (i == 0 || s.charAt(i - 1) == '(')) {
                    //     numStack.push(0);
                    // }

                    // KEY: here need to use "while" instead of "if" to handle "-" properly
                    // "1*2-3/4+5*6-7*8+9/10"
                    while (!operatorStack.isEmpty() && canProcede(c, operatorStack.peek())) {
                        // Another way to handle cases such as "-2 + 1" or "(-2) + 1"
                        int tmp = doOperation(operatorStack.pop(), numStack.pop(), numStack.isEmpty() ? 0 : numStack.pop());
                        numStack.push(tmp);
                    }

                    operatorStack.push(c);
                }
            }

            while (!operatorStack.isEmpty()) {
                int tmp = doOperation(operatorStack.pop(), numStack.pop(), numStack.isEmpty() ? 0 : numStack.pop());
                numStack.push(tmp);
            }

            return numStack.pop();
        }

        private boolean canProcede(char operatorCur, char operatorLast) {
            if (operatorLast == '(') {
                return false;
            }

            if ((operatorCur == '*' || operatorCur == '/') &&
                    (operatorLast == '+' || operatorLast == '-')) {
                return false;
            }

            return true;
        }

        private int doOperation(char operator, int num1, int num2) {
            // System.out.println("" + num2 + operator + num1);
            switch (operator) {
                case '+':
                    return num2 + num1;
                case '-':
                    return num2 - num1;
                case '*':
                    return num2 * num1;
                case '/':
                    return num2 / num1;
                default:
                    throw new IllegalArgumentException();
            }
        }

    }

}
