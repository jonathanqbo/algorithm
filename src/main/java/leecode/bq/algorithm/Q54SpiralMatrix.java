package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/5/21 10:17 PM
 */
public class Q54SpiralMatrix {

    /**
     * solution 1: moving by simulation + visited memory
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
     * Memory Usage: 37 MB, less than 78.19% of Java online submissions for Spiral Matrix.
     *
     */
    static class Solution {
        // Go clockwise: right -> down -> left -> up
        static final int[][] MOVES = {{0, 1},  {1, 0}, {0, -1}, {-1, 0}};

        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();

            int n = matrix.length;
            int m = matrix[0].length;
            int cells = n * m;
            boolean[][] visited = new boolean[n][m];

            int row = 0, col = 0;
            int direction = 0;
            // KEY: loop on cells, and turn direction everytime touching edge
            for (int i = 0; i < cells; i++) {
                result.add(matrix[row][col]);
                visited[row][col] = true;

                int nextRow = row + MOVES[direction][0];
                int nextCol = col + MOVES[direction][1];

                // if touching edge: either on edge of table or visited cell
                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && !visited[nextRow][nextCol]) {
                    row = nextRow;
                    col = nextCol;
                } else {
                    direction = (direction + 1) % 4;
                    row = row + MOVES[direction][0];
                    col = col + MOVES[direction][1];
                }
            }

            return result;
        }
    }


    /**
     * solution 2: layer by layer
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
     * Memory Usage: 36.7 MB, less than 98.18% of Java online submissions for Spiral Matrix.
     *
     */
    class Solution2 {

        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();

            int startRow = 0, startCol = 0, endRow = matrix.length - 1, endCol = matrix[0].length - 1;
            while (startRow <= endRow && startCol <= endCol) {
                visitOneLayer(result, matrix, startRow++, startCol++, endRow--, endCol--);
            }

            return result;
        }

        private void visitOneLayer(List<Integer> result, int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
            // go right
            for (int col = startCol; col <= endCol; col++) {
                result.add(matrix[startRow][col]);
            }

            // go down
            for (int row = startRow + 1; row <= endRow; row++) {
                result.add(matrix[row][endCol]);
            }

            // KEY: edge case: only 1 row or 1 col
            if (startRow < endRow && startCol < endCol) {
                // go left
                for (int col = endCol - 1; col >= startCol; col--) {
                    result.add(matrix[endRow][col]);
                }

                // go up
                for (int row = endRow - 1; row >= startRow + 1; row--) {
                    result.add(matrix[row][startCol]);
                }
            }
        }
    }

}
