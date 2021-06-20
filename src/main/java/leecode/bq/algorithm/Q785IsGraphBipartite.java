package leecode.bq.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:25 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q785IsGraphBipartite {

    /**

     solution: BFS and Tracking party for each node

     */

    class Solution {

        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            int[] nodeToParty = new int[n];

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n];

            // KEY: the nodes in graph could not connect each other
            for (int start = 0; start < n; start++) {
                if (visited[start]) {
                    continue;
                }

                queue.offer(start);
                visited[start] = true;
                nodeToParty[start] = 1;

                while (!queue.isEmpty()) {
                    int node = queue.poll();

                    for (int neighbor : graph[node]) {
                        if (nodeToParty[neighbor] == nodeToParty[node]) {
                            return false;
                        }

                        nodeToParty[neighbor] = -nodeToParty[node];

                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            return true;
        }
    }

}
