package leecode.bq.number;

/**
 * <b> </b>
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 *
 *
 * Created at 6/13/21 8:38 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q12IntegerToRoman {

    /**

     solution: keep minus value by symbol from big to small, and append symbol to result

     KEY: the order of two loop, the outer loop is ints/symbols, inner loop is num

     @see 13. Roman to Integer

     */
    class Solution {

        public String intToRoman(int num) {
            String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < symbols.length; i++) {
                while (num >= ints[i]) {
                    result.append(symbols[i]);
                    num -= ints[i];
                }
            }

            return result.toString();
        }

    }

}