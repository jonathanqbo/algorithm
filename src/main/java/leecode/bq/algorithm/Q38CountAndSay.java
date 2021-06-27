package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
 *
 * For example, the saying and conversion for digit string "3322251":
 *
 *
 * Given a positive integer n, return the nth term of the count-and-say sequence.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: "1"
 * Explanation: This is the base case.
 * Example 2:
 *
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/23/20 8:35 PM
 */
public class Q38CountAndSay {

    /**
     solution:
     dont need recursion, just need to calculate result from 0 to n, the result(N) relys only on result(N-1)

     NOTE: code template for : how to count and append to StringBuilder, how to handle the End case.
     -------------------------
     pre = num[0]
     count = 1
     for (i = 1, i < n; i++) {
        if (num[i] != pre) {
            sb.append()...
            pre = num[i];
            count = 1;
         }
     }

     sb.append()...

     */
    class Solution {

        public String countAndSay(int n) {
            // base
            String str = "1";

            // countAndSay(n-1)
            for (int i = 1; i < n; i++) {
                str = countAndSay(str);
            }

            return str;
        }

        private String countAndSay(String num) {
            StringBuilder result = new StringBuilder();
            int count = 1;
            char pre = num.charAt(0);
            for (int i = 1; i < num.length(); i++) {
                char c = num.charAt(i);

                if (c != pre) {
                    result.append(count).append(pre);

                    pre = c;
                    count = 1; // default count=1
                } else {
                    count++;
                }
            }

            // KEY: no matter the last is same as pre or not, the last always needs to be added to result
            result.append(count).append(pre);

            return result.toString();
        }

    }

}
