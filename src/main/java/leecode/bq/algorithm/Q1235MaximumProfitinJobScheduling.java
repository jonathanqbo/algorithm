package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 3/25/21 4:03 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q1235MaximumProfitinJobScheduling {

    /**
     * solution: DP[endtime]: the max profit in endtime
     *
     * sort job by endTime in ascending,
     * then dp[job.endtime] = Max(max, dp[job.starttime] + dp[job.profit])
     *
     * Runtime: 39 ms, faster than 45.33% of Java online submissions for Maximum Profit in Job Scheduling.
     * Memory Usage: 48.2 MB, less than 62.34% of Java online submissions for Maximum Profit in Job Scheduling.
     *
     */
    class Solution {

        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            List<Job> jobs = new ArrayList<>(startTime.length);
            for (int i = 0; i < startTime.length; i++) {
                jobs.add(new Job(startTime[i], endTime[i], profit[i]));
            }

            Collections.sort(jobs, (job1, job2) -> job1.endTime - job2.endTime);

            // endTime -> maxProfit
            TreeMap<Integer, Integer> dp = new TreeMap<>();
            // init
            dp.put(0, 0);

            for (Job job: jobs) {
                int maxProfitWithJob = dp.floorEntry(job.startTime).getValue() + job.profit;
                int maxProfitWithoutJob = dp.lastEntry().getValue();
                // only keep the result if max profit inceased, don't need save the maxProfit drop
                if (maxProfitWithJob > maxProfitWithoutJob) {
                    dp.put(job.endTime, maxProfitWithJob);
                }
            }

            return dp.lastEntry().getValue();
        }

        class Job {
            int startTime;
            int endTime;
            int profit;

            public Job(int startTime, int endTime, int profit) {
                this.startTime = startTime;
                this.endTime = endTime;
                this.profit = profit;
            }
        }
    }

}
