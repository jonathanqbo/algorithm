package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:06 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q463IslandPerimeter {

    /**

     solution 1: check each cell 4 sides, if it's water, then count

     solution 2 (perfer): same as solution 1, but using DIRS to check

     */

    class Solution {

        public int islandPerimeter(int[][] grid) {
            int count = 0;

            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] != 1) {
                        continue;
                    }

                    if (row == 0 || grid[row - 1][col] == 0) {
                        count++;
                    }
                    if (col == 0 || grid[row][col - 1] == 0) {
                        count++;
                    }
                    if (row == grid.length - 1 || grid[row + 1][col] == 0) {
                        count++;
                    }
                    if (col == grid[0].length - 1 || grid[row][col + 1] == 0) {
                        count++;
                    }
                }
            }

            return count;
        }

    }

}
