package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/6/21 3:57 PM
 */
public class Q763PartitionLabels {

    /**
     * solution: calculate last position, then one-loop find the max last-position until index==last-position
     */
    class Solution {

        public List<Integer> partitionLabels(String S) {
            // KEY: calculate last position for each char
            int[] lastPosition = new int[26];
            for (int i = 0; i < S.length(); i++) {
                lastPosition[S.charAt(i) - 'a'] = i;
            }

            List<Integer> result = new ArrayList<>();
            int start = 0, end = 0;
            for (int i = 0; i < S.length(); i++) {
                end = Math.max(lastPosition[S.charAt(i) - 'a'], end);
                // one partition found
                if (i == end) {
                    result.add(end - start + 1);
                    end = end + 1; // not necessary, since lastPosition always grow
                    start = end;
                }
            }

            return result;
        }

    }

}
