package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 *  solution: keep minus value by symbol from big to small, and append symbol to result
 *
 *  KEY: the order of two loop, the outer loop is ints/symbols, inner loop is num
 *
 *  @see 13. Roman to Integer
 *
 * <p>
 * Created at 6/13/21 8:38 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q12IntegerToRoman {

    public String intToRoman(int num) {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {
            while (num >= ints[i]) {
                result.append(symbols[i]);
                num -= ints[i];
            }
        }

        // This loop is not good:
        //
        // while (num > 0) {
        //     for (int i = 0; i < ints.length; i++) {
        //         if (num >= ints[i]) {
        //             result.append(symbols[i]);
        //             num -= ints[i];
        //             break;
        //         }
        //     }
        // }

        return result.toString();
    }


}