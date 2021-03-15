package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/12/21 11:07 PM
 */
public class Q332ReconstructItinerary {

    /**
     * solution 1: Backtracking + Greedy
     *
     * Runtime: 6 ms, faster than 56.16% of Java online submissions for Reconstruct Itinerary.
     * Memory Usage: 39.5 MB, less than 76.75% of Java online submissions for Reconstruct Itinerary.
     *
     */
    class Solution {
        public List<String> findItinerary(List<List<String>> tickets) {
            Map<String, List<String>> paths = new HashMap<>();
            Map<String, boolean[]> visited = new HashMap<>();

            // group by from-airport
            for (List<String> ticket : tickets) {
                String from = ticket.get(0);
                String to = ticket.get(1);

                paths.putIfAbsent(from, new ArrayList<String>());
                paths.get(from).add(to);
            }

            // sort by to-airport, and init visited-map
            for (Map.Entry<String, List<String>> kv: paths.entrySet()) {
                Collections.sort(kv.getValue());
                visited.put(kv.getKey(), new boolean[kv.getValue().size()]);
            }

            List<String> result = new ArrayList<>();
            String jfk = "JFK";
            result.add(jfk);
            backtrack(result, tickets.size() + 1, jfk, paths, visited);

            return result;
        }

        private boolean backtrack(List<String> result, int n, String fromAirport, Map<String, List<String>> flights, Map<String, boolean[]> visited) {
            // the first found is in lexical order
            if (result.size() == n) {
                return true;
            }

            if (!flights.containsKey(fromAirport)) {
                return false;
            }

            List<String> toAirports = flights.get(fromAirport);
            boolean[] visitedAirports = visited.get(fromAirport);
            for (int i = 0; i < toAirports.size(); i++) {
                if (visitedAirports[i]) {
                    continue;
                }

                String toAirport = toAirports.get(i);
                result.add(toAirport);
                visitedAirports[i] = true;

                if (backtrack(result, n, toAirport, flights, visited)) {
                    return true;
                }

                result.remove(result.size() - 1);
                visitedAirports[i] = false;
            }

            return false;
        }
    }

}
