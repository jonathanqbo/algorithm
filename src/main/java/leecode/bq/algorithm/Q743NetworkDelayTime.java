package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:23 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q743NetworkDelayTime {

    class Solution {

        public int networkDelayTime(int[][] times, int n, int k) {
            // build graph
            Map<Integer, List<Edge>> graph = new HashMap<>();
            for (int[] edge : times) {
                graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(new Edge(edge[1], edge[2]));
            }

            // Dijkstra
            PriorityQueue<Edge> heap = new PriorityQueue<>((edge1, edge2) -> edge1.distance - edge2.distance);
            heap.offer(new Edge(k, 0));

            Set<Integer> visited = new HashSet<>();

            int maxDistance = Integer.MIN_VALUE;
            int connNodeAmount = 0;
            while (!heap.isEmpty()) {
                Edge minEdge = heap.poll();

                if (visited.contains(minEdge.node)) {
                    continue;
                }
                visited.add(minEdge.node);

                maxDistance = minEdge.distance;
                connNodeAmount++;

                if (!graph.containsKey(minEdge.node)) {
                    continue;
                }

                for (Edge neighbor : graph.get(minEdge.node)) {
                    if (!visited.contains(neighbor.node)) {
                        heap.offer(new Edge(neighbor.node, neighbor.distance + minEdge.distance));
                    }
                }
            }

            // result
            return connNodeAmount < n ? -1 : maxDistance;
        }

    }

    class Edge {
        int node;
        int distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

}
