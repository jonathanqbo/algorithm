package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/18/21 9:16 PM
 */
public class Q204CountPrimes {

    /**
     * solution 1:
     *
     * Runtime: 491 ms, faster than 9.74% of Java online submissions for Count Primes.
     * Memory Usage: 35.6 MB, less than 95.96% of Java online submissions for Count Primes.
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count = 0;
        // 2 is the first prime
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            // until j*j <= n is good enough
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
            }
        }

        return count;
    }

    /**
     * solution 2: Sieve of Eratosthenes
     *
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        boolean[] marked = new boolean[n];

        // loop until i*i < n is good enough
        for (int i = 2; i * i < n; i++) {
            if (!marked[i]) {
                for (int j = 2; j * i < n; j++) {
                    marked[i*j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!marked[i]) {
                count++;
            }
        }

        return count;
    }

}
