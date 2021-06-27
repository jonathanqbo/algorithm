package leecode.bq.number;

/**
 * <b> </b>
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 *
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/25/21 10:25 PM
 */
public class Q43MultiplyStrings {

    /**

     solution: simulate the multiplication process

     key:
     keep a result array. the max length is: num1.length + num2.length
     from right to left, keep adding each digit into result[i]

        123
      x 456
     --------------------
         123 x 6
      + 123 x 5
     + 123 x 4
     --------------------
         738
      + 651
     + 429

     */
    class Solution {

        public String multiply(String n1, String n2) {
            int len1 = n1.length(), len2 = n2.length();

            // key: the max result length is len1+len2
            int[] digits = new int[len1 + len2];

            // accumulate adding digit*digit to each result digit
            for (int i = len1 - 1; i >= 0; i--) {
                int digit1 = n1.charAt(i) - '0';

                for (int j = len2 - 1; j >= 0; j--) {
                    int digit2 = n2. charAt(j)  - '0';

                    // key: calculate index of digits array from index i, j
                    int idx = i + j + 1;

                    int product = digit1 * digit2;
                    int number = digits[idx] + product;

                    digits[idx] = number % 10;
                    digits[idx - 1] += number / 10;
                }
            }

            // skip leading zero
            int i = 0;
            while (i < digits.length && digits[i] == 0) {
                i++;
            }

            // add left digits to result
            StringBuilder result = new StringBuilder();
            for (; i < digits.length; i++) {
                result.append(digits[i]);
            }

            // key: handle "0"
            return result.length() == 0 ? "0" : result.toString();
        }

    }

}
