package leecode.bq.algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 3/26/21 10:59 AM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q1192CriticalConnectionsinaNetwork {

    /**
     * solution: Find circle, and remove all the edges of the circles, the left are critical edges
     * key: use "rank" (ie depth) to check if there are circles
     *
     * Runtime: 300 ms, faster than 9.02% of Java online submissions for Critical Connections in a Network.
     * Memory Usage: 148.2 MB, less than 21.68% of Java online submissions for Critical Connections in a Network.
     *
     */
    class Solution {
        private Map<Integer, List<Integer>> graph = new HashMap<>();
        private Set<Edge> edges = new HashSet<>();
        private Map<Integer, Integer> ranks = new HashMap<>();

        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            //
            buildGraph(n, connections);

            //
            dfs(0, 0);

            // build result from left edges
            return edges.stream().map(edge -> Arrays.asList(edge.from, edge.to)).collect(Collectors.toList());
        }

        /**
         * key: return the rank that is in circle start node if existed, otherwise return rank+1
         */
        private int dfs(int node, int rank) {
            if (ranks.get(node) != null) {
                return ranks.get(node);
            }

            //
            ranks.put(node, rank);

            //
            int minRank = rank + 1;
            for (int neighbor : graph.get(node)) {
                Integer neighborRank = ranks.get(neighbor);
                // skip the pararent
                if (neighborRank != null && neighborRank == rank - 1) {
                    continue;
                }

                int circleNodeRank = dfs(neighbor, rank + 1);
                // circle existed
                if (circleNodeRank <= rank) {
                    edges.remove(new Edge(node, neighbor));
                }

                minRank = Math.min(minRank, circleNodeRank);
            }

            return minRank;
        }

        private void buildGraph(int n, List<List<Integer>> connections) {
            // init
            for (int i = 0; i < n; i++) {
                graph.put(i, new ArrayList<>());
                ranks.put(i, null);
            }

            for (List<Integer> edge: connections) {
                int nodeFrom = edge.get(0);
                int nodeTo = edge.get(1);

                graph.get(nodeFrom).add(nodeTo);
                graph.get(nodeTo).add(nodeFrom);

                edges.add(new Edge(nodeFrom, nodeTo));
            }
        }

        class Edge {
            int from;
            int to;

            public Edge(int from, int to) {
                this.from = Math.min(from, to);
                this.to = Math.max(from, to);
            }

            @Override
            public boolean equals(Object  obj) {
                if (this == obj) {
                    return true;
                }

                Edge target = (Edge) obj;
                return Objects.equals(this.from, target.from) &&
                        Objects.equals(this.to, target.to);
            }

            @Override
            public int hashCode() {
                return Objects.hash(from, to);
            }
        }
    }

}
