package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/17/21 10:50 PM
 */
public class Q412FizzBuzz {

    /**
     * solution 1:
     *
     * Runtime: 1 ms, faster than 99.74% of Java online submissions for Fizz Buzz.
     * Memory Usage: 39.9 MB, less than 84.71% of Java online submissions for Fizz Buzz.
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList(n);

        for (int i = 1; i <= n; i++) {
            int div5 = i % 5;
            int div3 = i % 3;
            if (div5 == 0 && div3 == 0) {
                result.add("FizzBuzz");
            } else if (div5 == 0) {
                result.add("Buzz");
            } else if (div3 == 0) {
                result.add("Fizz");
            } else {
                // Note: don't use String.valueOf(i), since it calls Integer.toString() underneath.
                result.add(Integer.toString(i));
            }
        }

        return result;
    }


    /**
     * solution 2: String concatenation
     *
     * Runtime: 2 ms, faster than 39.24% of Java online submissions for Fizz Buzz.
     * Memory Usage: 40.7 MB, less than 15.45% of Java online submissions for Fizz Buzz.
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz2(int n) {
        List<String> result = new ArrayList(n);

        for (int i = 1; i <= n; i++) {
            int div5 = i % 5;
            int div3 = i % 3;
            StringBuilder sb = new StringBuilder();

            // Note: order matters
            if (div3 == 0) {
                sb.append("Fizz");
            }
            if (div5 == 0) {
                sb.append("Buzz");
            }

            if (sb.length() == 0) {
                // Note: don't use String.valueOf(i), since it calls Integer.toString() underneath.
                sb.append(Integer.toString(i));
            }

            result.add(sb.toString());
        }

        return result;
    }

    /**
     * solution 3: hash with solution 2
     *
     * this solution is good for more complex mapping dict.
     *
     * Runtime: 6 ms, faster than 9.34% of Java online submissions for Fizz Buzz.
     * Memory Usage: 46.2 MB, less than 5.87% of Java online submissions for Fizz Buzz.
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz3(int n) {
        Map<Integer, String> dict = new LinkedHashMap();
        dict.put(3, "Fizz");
        dict.put(5, "Buzz");

        List<String> result = new ArrayList(n);

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, String> kv: dict.entrySet()) {
                if (i % kv.getKey() == 0) {
                    sb.append(kv.getValue());
                }
            }

            if (sb.length() == 0) {
                // Note: don't use String.valueOf(i), since it calls Integer.toString() underneath.
                result.add(Integer.toString(i));
            } else {
                result.add(sb.toString());
            }
        }

        return result;
    }

}
