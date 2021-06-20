package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:30 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q921MinimumAddtoMakeParenthesesValid {

    /**

     solution: balance

     ()))((

     KEY: if balance == -1, means need add one to keep it balance, then reset balance=0.

     */

    class Solution {

        public int minAddToMakeValid(String s) {
            int n = s.length();

            int balance = 0;
            int result = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') {
                    balance++;
                } else {
                    balance--;
                    if (balance == -1) {
                        result++;
                        balance = 0;
                    }
                }
            }

            return result + balance;
        }

    }

}
