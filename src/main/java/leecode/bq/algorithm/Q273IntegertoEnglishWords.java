package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 3/26/21 5:42 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q273IntegertoEnglishWords {

    /**
     * Runtime: 2 ms, faster than 93.63% of Java online submissions for Integer to English Words.
     * Memory Usage: 38.4 MB, less than 68.81% of Java online submissions for Integer to English Words.
     */
    class Solution {
        final String[] LESS20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

        public String numberToWords(int num) {
            if (num == 0) {
                return "Zero";
            }

            StringBuilder result = new StringBuilder();
            int thousandsUnit = 0;
            while (num > 0) {
                if (num % 1000 != 0) {
                    result = new StringBuilder(helper(num % 1000))
                            .append(THOUSANDS[thousandsUnit]).append(" ")
                            .append(result);
                }

                num = num / 1000;
                // this must be outside of if(num%1000)
                thousandsUnit++;
            }

            // key: trim() here can simplify all those 100, 1000 .. cases
            return result.toString().trim();
        }

        /**
         * note, return string endwith " " to simplify the space handling
         */
        private String helper(int num) {
            if (num == 0) {
                return "";
            }

            if (num < 20) {
                return new StringBuilder(LESS20[num]).append(" ").toString();
            }

            if (num < 100) {
                return new StringBuilder(TENS[num / 10]).append(" ").append(helper(num % 10)).toString();
            }

            return new StringBuilder(LESS20[num / 100]).append(" Hundred").append(" ").append(helper(num % 100)).toString();
        }
    }

}
