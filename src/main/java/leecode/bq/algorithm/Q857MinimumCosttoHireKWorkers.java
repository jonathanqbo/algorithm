package leecode.bq.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/7/21 5:04 PM
 */
public class Q857MinimumCosttoHireKWorkers {

    /**
     * solution: sort by ratio, then maintain PriorityQueue keeping minimal amount of Quality, calculate cost for each item K and above
     *
     * Runtime: 22 ms, faster than 94.82% of Java online submissions for Minimum Cost to Hire K Workers.
     * Memory Usage: 39.9 MB, less than 85.80% of Java online submissions for Minimum Cost to Hire K Workers.
     *
     * @param quality
     * @param wage
     * @param K
     * @return
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] workers = new Worker[quality.length];
        for (int i = 0; i < quality.length; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }

        // ratio (w/q): sort in ASC: the bigger, the more workers meet wage
        // the workers in left side of current worker meet their wage
        Arrays.sort(workers, (worker1, worker2) -> Double.compare(worker1.ratio, worker2.ratio));

        // max-heap PriorityQueue for quality:
        // bigger quality out first.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((quality1, quality2) -> Integer.compare(quality2, quality1));

        double minCost = Double.MAX_VALUE;
        int sumQuality = 0;
        for (int i = 0; i < workers.length; i++) {
            // add quality of current worker
            sumQuality += workers[i].quality;
            maxHeap.offer(workers[i].quality);
            if (i < K - 1) {
                continue;
            }

            if (i > K - 1) {
                // remove the biggest quality
                // and minuss it from sumQuality
                sumQuality -= maxHeap.poll();
            }

            // cost = the biggest ratio (which is current worker.ratio) * min(sumQuality)
            minCost = Math.min(minCost, sumQuality * workers[i].ratio);
        }

        return minCost;
    }

    static class Worker {

        int quality;
        double ratio;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.ratio = ((double)wage) / quality;
        }

    }

}
