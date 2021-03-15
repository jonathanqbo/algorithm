package leecode.bq.algorithm;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/12/21 5:43 PM
 */
public class Q994RottingOranges {

    /**
     * solution: BFS on forest (multiple trees)
     *
     * Runtime: 3 ms, faster than 62.63% of Java online submissions for Rotting Oranges.
     * Memory Usage: 38.2 MB, less than 90.68% of Java online submissions for Rotting Oranges.
     *
     */
    class Solution {
        public int orangesRotting(int[][] grid) {
            Queue<Position> queue = new ArrayDeque<>();

            int rows = grid.length;
            int cols = grid[0].length;
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

            int freshOrangeAmount = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 2) {
                        queue.offer(new Position(i, j));
                    } else if (grid[i][j] == 1) {
                        freshOrangeAmount++;
                    }
                }
            }

            // no fresh orange at all
            if (freshOrangeAmount == 0) {
                return 0;
            }

            //
            int level = 0;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    Position curPos = queue.poll();

                    // check each neighbors
                    for (int[] direction : directions) {
                        int row = curPos.row + direction[0];
                        int col = curPos.col + direction[1];
                        if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == 1) {
                            grid[row][col] = 2;
                            freshOrangeAmount--;
                            queue.offer(new Position(row, col));
                        }
                    }
                }

                level++;
            }

            // KEY: check freshOrangeAmount == 0 instead of freshOrangeAmount > 0
            return freshOrangeAmount == 0 ? level - 1 : -1;
        }

        class Position {
            int row;
            int col;

            public Position(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }
    }

}
