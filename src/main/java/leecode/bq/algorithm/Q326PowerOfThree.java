package leecode.bq.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/18/21 9:59 PM
 */
public class Q326PowerOfThree {

    /**
     * solution 1: naive
     *
     * Runtime: 10 ms, faster than 99.97% of Java online submissions for Power of Three.
     * Memory Usage: 38.7 MB, less than 74.86% of Java online submissions for Power of Three.
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    /**
     * solution 2: get all candidates
     *
     * Runtime: 17 ms, faster than 23.28% of Java online submissions for Power of Three.
     * Memory Usage: 38.9 MB, less than 35.53% of Java online submissions for Power of Three.
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree2(int n) {
        Set<Integer> candidates = new HashSet();
        int i = 1;
        candidates.add(i);

        while (i <= n / 3) {
            i *= 3;
            candidates.add(i);
        }

        return candidates.contains(n);
    }

    /**
     * solution 3: cheating :)
     *
     * the max 3n number is 3 power 19 which is 1162261467
     *
     * Runtime: 10 ms, faster than 99.97% of Java online submissions for Power of Three.
     * Memory Usage: 38.8 MB, less than 61.84% of Java online submissions for Power of Three.
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
