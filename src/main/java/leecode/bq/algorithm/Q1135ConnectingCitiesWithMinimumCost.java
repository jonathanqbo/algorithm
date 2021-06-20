package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/20/21 10:23 AM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q1135ConnectingCitiesWithMinimumCost {

    /**

     this problem is: connect all cities, but doesnt need to connect in one un-repeated path.

     f -> g
     |
     a -> b -> c -> d
     |
     e

     solution: bfs with PriorityQueue

     key: when do bfs using PriorityQueue, always try to connect other city from the shortest path

     */
    class Solution {

        public int minimumCost(int N, int[][] connections) {
            Map<Integer, List<int[]>> graph = new HashMap<>();
            for (int i = 0; i < connections.length; i++) {
                int[] edge = connections[i];
                int node1 = edge[0], node2 = edge[1], weight = edge[2];

                graph.computeIfAbsent(node1, n -> new ArrayList<>()).add(new int[]{node2, weight});
                graph.computeIfAbsent(node2, n -> new ArrayList<>()).add(new int[]{node1, weight});
            }

            int result = 0;

            Queue<int[]> queue = new PriorityQueue<>((edge1, edge2) -> edge1[1] - edge2[1]);
            queue.offer(new int[] {1, 0});

            Set<Integer> visited = new HashSet<>(); // use int[N + 1] drop rumtime from 45ms to 34ms
            while (!queue.isEmpty()) {
                int[] edge = queue.poll();
                int node = edge[0];
                int weight = edge[1];

                // KEY: this check is needed even we check neighbor before adding into queue, since we change the order of visited after that
                if (visited.contains(node)) {
                    continue;
                }

                result += weight;
                visited.add(node);
                if (visited.size() == N) {
                    return result;
                }

                for (int[] neighborEdge : graph.get(node)) {
                    int neighbor = neighborEdge[0];
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighborEdge);
                    }
                }
            }

            return -1;
        }

    }

}
