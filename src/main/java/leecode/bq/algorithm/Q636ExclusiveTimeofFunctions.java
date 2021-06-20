package leecode.bq.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:22 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q636ExclusiveTimeofFunctions {

    /**

     count the time that the function itself takes, if it has other functions call inside it, that time only count on the other functions, not on the function itself

     0 ... (1 .. (2 ... 2) .. 1) ... 0
     |  0  ||  1 ||  2  ||  1 ||  0  |


     Use Stack of function id
     if function start: - push to stack
     if cuntion end: - calculate cur function timecost, pop stack, and minus this timecost from parent.

     */
    class Solution {

        public int[] exclusiveTime(int n, List<String> logs) {
            int[] result = new int[n];

            Deque<Log> stack = new ArrayDeque<>();
            for (String strLog : logs) {
                Log log = new Log(strLog);
                if (log.start) {
                    stack.push(log);
                } else {
                    Log pre = stack.pop();
                    int timecost = log.time - pre.time + 1;
                    result[log.id] += timecost;

                    if (!stack.isEmpty()) {
                        result[stack.peek().id] -= timecost;
                    }
                }
            }

            return result;
        }

    }

    class Log {
        int id;
        boolean start;
        int time;

        public Log(String log) {
            String[] vals = log.split(":");
            id = Integer.parseInt(vals[0]);
            start = vals[1].equals("start") ? true : false;
            time = Integer.parseInt(vals[2]);
        }
    }

}
