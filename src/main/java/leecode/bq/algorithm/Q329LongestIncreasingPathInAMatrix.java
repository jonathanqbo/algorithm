package leecode.bq.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/10/21 9:58 PM
 */
public class Q329LongestIncreasingPathInAMatrix {

    // moving along 4 direcctions: {x, y}
    private static final int[][] MOVINGS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * solution 1: dfs with memorization
     *
     * Runtime: 7 ms, faster than 88.87% of Java online submissions for Longest Increasing Path in a Matrix.
     * Memory Usage: 39.4 MB, less than 53.30% of Java online submissions for Longest Increasing Path in a Matrix.
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        int result = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(matrix, i, j, cache));
            }
        }

        return result;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        int result = 0;

        int m = matrix.length;
        int n = matrix[0].length;
        for (int[] move: MOVINGS) {
            int x = i + move[0];
            int y = j + move[1];

            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                result = Math.max(result, dfs(matrix, x, y, cache));
            }
        }

        result++;
        cache[i][j] = result;

        return result;
    }

    /**
     * solution 2: peel onion
     *
     * Runtime: 14 ms, faster than 26.58% of Java online submissions for Longest Increasing Path in a Matrix.
     * Memory Usage: 39.7 MB, less than 39.50% of Java online submissions for Longest Increasing Path in a Matrix.
     *
     */
    static class Solution2 {
        private static final int[][] MOVINGS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int longestIncreasingPath(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;

            Queue<int[]> q = new LinkedList<>();

            // build outDegree and add leaves node into q
            int[][] outDegree = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] move: MOVINGS) {
                        int x = i + move[0];
                        int y = j + move[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] < matrix[i][j]) {
                            outDegree[i][j]++;
                        }
                    }

                    // add leave nodes into queue
                    if (outDegree[i][j] == 0) {
                        q.offer(new int[] {i, j});
                    }
                }
            }


            // peel onion level by level
            int level = 0;
            int levelSize = q.size(); // levelsize to know which level it is
            while (!q.isEmpty()) {
                int[] node = q.poll();
                int i = node[0];
                int j = node[1];

                for(int[] move: MOVINGS) {
                    int x = i + move[0];
                    int y = j + move[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                        outDegree[x][y]--;
                        if (outDegree[x][y] == 0) {
                            q.offer(new int[]{x, y});
                        }
                    }
                }

                levelSize--;
                if (levelSize == 0) {
                    level++;
                    levelSize = q.size();
                }
            }

            return level;
        }
    }

}
