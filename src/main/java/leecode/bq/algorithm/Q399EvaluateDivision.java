package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/12/21 10:33 PM
 */
public class Q399EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // build graph
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<String, Double>());
            graph.putIfAbsent(b, new HashMap<String, Double>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1 / value);
        }

        // DFS + backtracking
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String c = query.get(0);
            String d = query.get(1);


            if (!graph.containsKey(c) || !graph.containsKey(d)) {
                result[i] = -1.0;
            } else if (c.equals(d)) {
                result[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(graph, c, d, 1, visited);
            }
        }

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String nodeFrom, String nodeTarget, double midResult, Set<String> visited) {
        if (visited.contains(nodeFrom)) {
            return -1.0;
        }

        visited.add(nodeFrom);
        double result = -1.0;

        Map<String, Double> neighbors = graph.get(nodeFrom);
        if (neighbors.containsKey(nodeTarget)) {
            result = midResult * neighbors.get(nodeTarget);
        } else {
            for (Map.Entry<String, Double> kv: neighbors.entrySet()) {
                String node = kv.getKey();
                double value = kv.getValue();
                if (!visited.contains(node)) {
                    double tmp = dfs(graph, node, nodeTarget, midResult * value, visited);
                    if (tmp != -1.0) {
                        result = tmp;
                        break;
                    }
                }
            }
        }

        visited.remove(nodeFrom);
        return result;
    }

}
