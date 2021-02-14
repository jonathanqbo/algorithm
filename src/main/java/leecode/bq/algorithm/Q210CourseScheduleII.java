package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/9/21 10:24 PM
 */
public class Q210CourseScheduleII {

    /**
     * solution: graph traverse
     *
     * Runtime: 5 ms, faster than 70.85% of Java online submissions for Course Schedule II.
     * Memory Usage: 40 MB, less than 79.41% of Java online submissions for Course Schedule II.
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        // build graph and indegree
        for (int[] edge: prerequisites) {
            int from = edge[1];
            int to = edge[0];

            graph.putIfAbsent(from, new LinkedList<Integer>());
            graph.get(from).add(to);

            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        // init q adding all nodes with indgree == 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int i = 0;
        // start from each node in q, and get all the child nodes
        while (!q.isEmpty()) {
            int node = q.poll();
            result[i++] = node;

            if (!graph.containsKey(node)) {
                continue;
            }

            List<Integer> children = graph.get(node);
            for (Integer child: children) {
                indegree[child]--;
                // if there is a standalone circle, the circle will never be reached
                // since it's no way to reach it from nodes with indegree == 0
                // and the indegree of visited node will become <0 if being visited again in a circle,
                // so the node won't be add to q again.
                if (indegree[child] == 0) {
                    q.offer(child);
                }
            }
        }

        return i == numCourses ? result : new int[0];
    }

}
