package leecode.bq.algorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/14/21 11:17 PM
 */
public class Q362DesignHitCounter {

    /**
     *
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Design Hit Counter.
     * Memory Usage: 37.2 MB, less than 41.30% of Java online submissions for Design Hit Counter.
     */
    class HitCounter {
        private Queue<Integer> hits;

        /** Initialize your data structure here. */
        public HitCounter() {
            this.hits = new LinkedList<Integer>();
        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            this.hits.add(timestamp);
        }

        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            while (!this.hits.isEmpty()) {
                int diff = timestamp - this.hits.peek();
                if (diff >= 300) this.hits.remove();
                else break;
            }
            return this.hits.size();
        }
    }


    /**
     * solution 2: count and keep one record for same timestamp
     *
     * Runtime: 1 ms, faster than 94.63% of Java online submissions for Design Hit Counter.
     * Memory Usage: 37.1 MB, less than 72.18% of Java online submissions for Design Hit Counter.
     */
    class HitCounter2 {

        private int total;
        private Deque<Hit> hits;

        /** Initialize your data structure here. */
        public HitCounter2() {
            hits = new LinkedList<>();
            total = 0;
        }

        /** Record a hit.
         @param timestamp - The current timestamp (in seconds granularity). */
        public void hit(int timestamp) {
            total++;

            if (hits.isEmpty()) {
                hits.offer(new Hit(timestamp, 1));
                return;
            }

            Hit lastHit = hits.peekLast();
            if (lastHit.timestamp == timestamp) {
                lastHit.amount++;
            } else {
                hits.offer(new Hit(timestamp, 1));
            }
        }

        /** Return the number of hits in the past 5 minutes.
         @param timestamp - The current timestamp (in seconds granularity). */
        public int getHits(int timestamp) {
            while (!hits.isEmpty() && timestamp - hits.peek().timestamp >= 300) {
                total -= hits.poll().amount;
            }

            return total;
        }

        class Hit {
            int timestamp;
            int amount;

            public Hit(int timestamp, int amount) {
                this.timestamp = timestamp;
                this.amount = amount;
            }
        }
    }


}
