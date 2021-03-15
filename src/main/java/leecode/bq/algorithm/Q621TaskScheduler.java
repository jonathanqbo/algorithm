package leecode.bq.algorithm;

import java.util.Arrays;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/14/21 11:13 PM
 */
public class Q621TaskScheduler {

    /**
     * solution: get the max frequency and fill others into the cool down gap
     *
     * Runtime: 2 ms, faster than 99.79% of Java online submissions for Task Scheduler.
     * Memory Usage: 40.2 MB, less than 73.69% of Java online submissions for Task Scheduler.
     */
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            // count
            // tasks are upper-case english letter
            int[] count = new int[26];
            for (char task: tasks) {
                count[task - 'A']++;
            }

            // sort: this problem doesn't care what task is, only task's amount
            Arrays.sort(count);

            // max idle time
            int maxCount = count[25];
            int maxIdle = (maxCount - 1) * n;

            for (int i = count.length - 2; i >= 0 && maxIdle > 0; i--) {
                // KEY: for cases the count is same as the max one, it should be biggest count - 1
                maxIdle -= Math.min(maxCount - 1, count[i]);
            }

            maxIdle = Math.max(0, maxIdle);

            // KEY: the cooldown 'n' is the least gap needed, so all other tasks can fit it the gap of the max one
            // so we only to care about the max one.
            return maxIdle + tasks.length;
        }
    }

}
