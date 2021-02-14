package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/13/21 9:12 PM
 */
public class Q200NumberofIslands {

    /**
     * solution: Union-Find
     *
     * Runtime: 2 ms, faster than 51.51% of Java online submissions for Number of Islands.
     * Memory Usage: 41.1 MB, less than 96.89% of Java online submissions for Number of Islands.
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        UnionFind uf = new UnionFind(m * n);
        // init
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    uf.init(i * n + j);
                }
            }
        }

        // union
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }

                if (i - 1 >= 0 && grid[i-1][j] == '1') {
                    uf.union(i * n + j, (i - 1) * n + j);
                }
                if (i + 1 < m && grid[i+1][j] == '1') {
                    uf.union(i * n + j, (i + 1) * n + j);
                }
                if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                    uf.union(i * n + j, i * n + j - 1);
                }
                if (j + 1 < n && grid[i][j + 1] == '1') {
                    uf.union(i * n + j, i * n + j + 1);
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


    /**
     * solution 2: DFS
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Number of Islands.
     * Memory Usage: 41.6 MB, less than 45.05% of Java online submissions for Number of Islands.
     *
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        grid[i][j] = '0';

        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(grid, i - 1, j);
        }
        if (i + 1 < m && grid[i + 1][j] == '1') {
            dfs(grid, i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(grid, i, j - 1);
        }
        if (j + 1 < n && grid[i][j + 1] == '1') {
            dfs(grid, i, j + 1);
        }
    }


    /**
     * solution 3: BFS
     *
     * Runtime: 4 ms, faster than 20.93% of Java online submissions for Number of Islands.
     * Memory Usage: 41.5 MB, less than 67.26% of Java online submissions for Number of Islands.
     *
     * @param grid
     * @return
     */
    public int numIslands3(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }

                count++;

                Queue<Integer> q = new LinkedList<>();
                // set to 0 before adding to queue
                grid[i][j] = '0';
                q.offer(i * n + j);

                while (!q.isEmpty()) {
                    int idx = q.poll();
                    int r = idx / n;
                    int c = idx % n;

                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        grid[r - 1][c] = '0';
                        q.offer((r - 1) * n + c);
                    }
                    if (r + 1 < m && grid[r + 1][c] == '1') {
                        grid[r + 1][c] = '0';
                        q.offer((r + 1) * n + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        grid[r][c - 1] = '0';
                        q.offer(r * n + c - 1);
                    }
                    if (c + 1 < n && grid[r][c + 1] == '1') {
                        grid[r][c + 1] = '0';
                        q.offer(r * n + c + 1);
                    }
                }
            }
        }

        return count;
    }

}
