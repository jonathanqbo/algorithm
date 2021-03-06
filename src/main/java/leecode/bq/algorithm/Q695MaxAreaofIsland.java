package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/6/21 11:13 AM
 */
public class Q695MaxAreaofIsland {

    /**
     * solution 1: DFS + memory
     *
     * Runtime: 4 ms, faster than 31.35% of Java online submissions for Max Area of Island.
     * Memory Usage: 44.7 MB, less than 8.36% of Java online submissions for Max Area of Island.
     *
     */
    class Solution1 {
        public int maxAreaOfIsland(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;

            boolean[][] visited = new boolean[rows][cols];
            int maxArea = 0;
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    maxArea = Math.max(maxArea, area(grid, row, col, visited));
                }
            }

            return maxArea;
        }

        private int area(int[][] grid, int row, int col, boolean[][] visited) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || visited[row][col]) {
                return 0;
            }

            visited[row][col] = true;

            return 1 + area(grid, row + 1, col, visited)
                    + area(grid, row - 1, col, visited)
                    + area(grid, row, col + 1, visited)
                    + area(grid, row, col - 1, visited);
        }
    }


    /**
     * solution 2: DFS without memory
     *
     * Runtime: 3 ms, faster than 52.20% of Java online submissions for Max Area of Island.
     * Memory Usage: 44.3 MB, less than 16.25% of Java online submissions for Max Area of Island.
     *
     */
    class Solution2 {
        public int maxAreaOfIsland(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;

            int maxArea = 0;
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    maxArea = Math.max(maxArea, area(grid, row, col));
                }
            }

            return maxArea;
        }

        private int area(int[][] grid, int row, int col) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
                return 0;
            }

            // KEY: just need simply set visited grid to 0
            grid[row][col] = 0;

            return 1 + area(grid, row + 1, col)
                    + area(grid, row - 1, col)
                    + area(grid, row, col + 1)
                    + area(grid, row, col - 1);
        }
    }

}
