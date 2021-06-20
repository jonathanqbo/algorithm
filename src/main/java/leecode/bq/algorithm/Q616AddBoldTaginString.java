package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:20 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q616AddBoldTaginString {

    /**

     solution 1: Merge Interval

     ---------

     solution 2: Keep tracking Right Most Bold Position + Bold array

     */

    class Solution {

        public String addBoldTag(String s, String[] dict) {
            int n = s.length();

            //
            boolean[] bolds = new boolean[n];

            int right = 0;
            for (int i = 0; i < n; i++) {
                for (String word : dict) {
                    if (s.startsWith(word, i)) {
                        right = Math.max(right, i + word.length());
                    }
                }

                if (right > i) {
                    bolds[i] = true;
                }
            }

            // key: how to build string from bolds array
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (!bolds[i]) {
                    sb.append(s.charAt(i));
                    continue;
                }

                int j = i;
                sb.append("<b>");
                while (j < n && bolds[j]) {
                    sb.append(s.charAt(j++));
                }
                sb.append("</b>");

                i = j - 1;
            }

            return sb.toString();
        }

    }

    class Solution2 {

        public String addBoldTag(String s, String[] dict) {
            //
            List<int[]> intervals =  parseIntervals(s, dict);

            // merge intervals
            List<int[]> mergedIntervals = merge(intervals);

            //
            return buildResult(s, mergedIntervals);
        }

        private List<int[]> parseIntervals(String s, String[] dict) {
            List<int[]> intervals = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                int maxMatchRightIdx = -1;
                for (String word : dict) {
                    if (word.length() > s.length() - i) {
                        continue;
                    }

                    if (s.startsWith(word, i)) {
                        maxMatchRightIdx = Math.max(maxMatchRightIdx, i + word.length());
                    }
                }

                if (maxMatchRightIdx > i) {
                    intervals.add(new int[]{i, maxMatchRightIdx});
                }
            }

            return intervals;
        }

        private List<int[]> merge(List<int[]> intervals) {
            List<int[]> result = new ArrayList<>();

            for (int[] interval : intervals) {
                if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                    result.add(interval);
                } else {
                    int[] last = result.get(result.size() - 1);
                    last[1] = Math.max(interval[1], last[1]); // remember to pick the max one
                }
            }

            return result;
        }

        private String buildResult(String s, List<int[]> intervals) {
            StringBuilder sb = new StringBuilder();

            int end = 0;
            for (int[] interval : intervals) {
                sb.append(s.substring(end, interval[0]))
                        .append("<b>")
                        .append(s.substring(interval[0], interval[1]))
                        .append("</b>");

                end = interval[1];
            }

            if (end < s.length()) {
                sb.append(s.substring(end, s.length()));
            }

            return sb.toString();
        }

    }

}
