package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/20/21 11:56 PM
 */
public class Q359LoggerRateLimiter {

    /**
     * solution 1: Map - keep the latest one for each unique messages
     * cons: no self clean mechanism
     *
     * Runtime: 30 ms, faster than 28.39% of Java online submissions for Logger Rate Limiter.
     * Memory Usage: 47.5 MB, less than 35.82% of Java online submissions for Logger Rate Limiter.
     *
     */
    class Logger {
        Map<String, Integer> cache;

        /** Initialize your data structure here. */
        public Logger() {
            cache = new HashMap<>();
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!cache.containsKey(message)) {
                cache.put(message, timestamp);
                return true;
            }

            if (timestamp - cache.get(message) >= 10) {
                cache.put(message, timestamp);
                return true;
            } else {
                return false;
            }

        }
    }

    /**
     * solution 2: Circular Buffer - Buckets by each second
     *
     * Runtime: 82 ms, faster than 5.27% of Java online submissions for Logger Rate Limiter.
     * Memory Usage: 75.8 MB, less than 6.40% of Java online submissions for Logger Rate Limiter.
     *
     */
    class Logger2 {
        int[] buckets;
        Set<String>[] caches;

        /** Initialize your data structure here. */
        public Logger2() {
            caches = new Set[10];
            for (int i = 0; i < 10; i++) {
                caches[i] = new HashSet<>();
            }

            buckets = new int[10];
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            int idx = timestamp % 10;

            // clean outdated buckets
            if (buckets[idx] != timestamp) {
                caches[idx] = new HashSet<>();
                buckets[idx] = timestamp;
            }

            for (int i = 0; i < buckets.length; i++) {
                if (timestamp - buckets[i] <= 10 && caches[i].contains(message)) {
                    return false;
                }
            }

            caches[idx].add(message);
            return true;
        }
    }

}
