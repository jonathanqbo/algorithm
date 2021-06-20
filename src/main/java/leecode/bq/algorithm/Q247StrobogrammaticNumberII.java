package leecode.bq.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 9:20 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q247StrobogrammaticNumberII {

    class Solution {
        public List<String> findStrobogrammatic(int n) {
            return helper(n, n);
        }

        private List<String> helper(int n, int m) {
            if (n == 0) {
                return Arrays.asList("");
            }
            if (n == 1) {
                return Arrays.asList("0", "1", "8");
            }

            List<String> midResult = helper(n - 2, m);

            List<String> result = new LinkedList<>();
            for (String subString: midResult) {
                if (n != m) {
                    result.add("0" + subString + "0");
                }

                result.add("1" + subString + "1");
                result.add("6" + subString + "9");
                result.add("8" + subString + "8");
                result.add("9" + subString + "6");
            }

            return result;
        }
    }

}
