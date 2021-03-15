package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/14/21 11:11 PM
 */
public class Q207CourseSchedule {

    /**
     * solution: graph with indegree check
     *
     * Runtime: 5 ms, faster than 65.21% of Java online submissions for Course Schedule.
     * Memory Usage: 39.4 MB, less than 84.91% of Java online submissions for Course Schedule.
     */
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            int[] indegrees = new int[numCourses];

            // build graph and indgress
            for (int i = 0; i < prerequisites.length; i++) {
                int[] edge = prerequisites[i];
                graph.putIfAbsent(edge[1], new LinkedList<>());
                graph.get(edge[1]).add(edge[0]);

                indegrees[edge[0]]++;
            }

            // start from nodes with 0 indgrees
            Queue<Integer> nodes = new LinkedList<>();
            for (int i = 0; i < indegrees.length; i++) {
                if (indegrees[i] == 0) {
                    nodes.add(i);
                }
            }

            // keep removing edges on nodes with 0 indegree until there is no nodes with 0 indegree
            int removedNodeAmount = 0;
            while (!nodes.isEmpty()) {
                Integer node = nodes.poll();
                removedNodeAmount++;

                List<Integer> toNodes = graph.getOrDefault(node, new LinkedList<>());
                for (int toNode : toNodes) {
                    indegrees[toNode]--;
                    if (indegrees[toNode] == 0) {
                        nodes.offer(toNode);
                    }
                }
            }

            return removedNodeAmount == numCourses;
        }
    }

}
