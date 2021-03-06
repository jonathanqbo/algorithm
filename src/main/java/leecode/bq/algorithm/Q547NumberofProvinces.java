package leecode.bq.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/4/21 11:18 PM
 */
public class Q547NumberofProvinces {

    /**
     * solution 1: DFS
     * KEY: 2d array represents graph
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Provinces.
     * Memory Usage: 39.9 MB, less than 56.93% of Java online submissions for Number of Provinces
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        // city amount
        int n = isConnected.length;

        int result = 0;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) {
                continue;
            }

            dfs(isConnected, visited, i);
            result++;
        }

        return result;
    }

    private void dfs(int[][] graph, int[] visited, int city) {
        visited[city] = 1;

        for (int i = 0; i < graph.length; i++) {
            if (graph[city][i] == 1 && visited[i] == 0) {
                dfs(graph, visited, i);
            }
        }
    }


    /**
     * solution 2: BFS
     *
     * Runtime: 5 ms, faster than 23.12% of Java online submissions for Number of Provinces.
     * Memory Usage: 39.2 MB, less than 99.70% of Java online submissions for Number of Provinces.
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum2(int[][] isConnected) {
        int n = isConnected.length;

        int result = 0;
        int[] visited = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] != 0) {
                continue;
            }

            queue.offer(i);
            while (!queue.isEmpty()) {
                int city = queue.poll();
                visited[city] = 1;
                for (int j = 0; j < n; j++) {
                    if (isConnected[city][j] == 1 && visited[j] == 0) {
                        queue.offer(j);
                    }
                }
            }

            result++;
        }

        return result;
    }


    /**
     * solution 3: Union-Find
     *
     * Runtime: 1 ms, faster than 73.08% of Java online submissions for Number of Provinces.
     * Memory Usage: 39.9 MB, less than 67.67% of Java online submissions for Number of Provinces.
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum3(int[][] isConnected) {
        int n = isConnected.length;

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            uf.init(i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return uf.count;
    }

    static class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            count = 0;
        }

        public void init(int x) {
            parent[x] = x;
            rank[x] = 1;

            count++;
        }

        public int find(int x) {
            if (parent[x] != x) {
                // so called path compression
                parent[x] = find(parent[x]);
                // without path compression:
                // x = parent[x];
            }

            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }

            if (rank[rootX] == rank[rootY]) {
                parent[rootY] = rootX;
                rank[rootX]++;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
            }

            count--;
            return true;
        }

    }
}
