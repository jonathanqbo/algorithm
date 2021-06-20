package leecode.bq.algorithm;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/20/21 10:22 AM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q1152AnalyzeUserWebsiteVisitPattern {

    /**

     1) group by user
     2) for each user:
     2.1) sort list by timestamp
     2.2) find all combination
     3) count combination on all users
     4) find the combination with max count and min website_name (if multiple one have same max count)

     */
    class Solution {

        public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
            // user to Visit List
            Map<String, List<Visit>> groups = IntStream.range(0, username.length)
                    .mapToObj(i -> new Visit(username[i], timestamp[i], website[i]))
                    .collect(Collectors.groupingBy(visit -> visit.userName));

            // sort Visit List by timestamp
            // calculate all Triple combinations
            // count by combination
            Map<List<String>, Long> combCounts = groups.values().stream()
                    .map(list -> list.stream().sorted(Comparator.comparing(v -> v.timestamp)).collect(Collectors.toList()))
                    .map(this::tripleCombination)
                    .flatMap(list -> list.stream())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            // find the max: max frequency and min lexicographical if multiple
            List<String> combo = combCounts.entrySet().stream()
                    .max(Comparator.comparing(Map.Entry<List<String>, Long>::getValue)
                            .thenComparing((kv1, kv2) -> kv2.getKey().toString().compareTo(kv1.getKey().toString())))
                    .map(kv -> kv.getKey())
                    .get();

            return combo;
        }

        private List<List<String>> tripleCombination(List<Visit> visits) {
            Set<List<String>> result = new HashSet<>();
            for (int i = 0; i < visits.size() - 2; i++) {
                for (int j = i + 1; j < visits.size() - 1; j++) {
                    for (int k = j + 1; k < visits.size(); k++) {
                        result.add(Arrays.asList(visits.get(i).website, visits.get(j).website, visits.get(k).website));
                    }
                }
            }

            return new ArrayList(result);
        }

        class Visit {
            String userName;
            int timestamp;
            String website;

            public Visit(String userName, int timestamp, String website) {
                this.userName = userName;
                this.timestamp = timestamp;
                this.website = website;
            }
        }

    }

}
