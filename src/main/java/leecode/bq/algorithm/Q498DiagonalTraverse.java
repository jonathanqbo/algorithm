package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:09 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q498DiagonalTraverse {

    /**
     solution 1: Move along the path by Direction

     KEY: how to handle next position out of boundary

     ------------

     solution 2: HashMap<Diagonal, List<value>>

     KEY: keep all diagonal: row+col == 0, 1, 2, 3, 4, then reverse each even row.

     */

    class Solution {

        public int[] findDiagonalOrder(int[][] mat) {
            int rows = mat.length;
            int cols = mat[0].length;

            Map<Integer, List<Integer>> diagonalToList = new HashMap<>();
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    diagonalToList.computeIfAbsent(row + col, k -> new ArrayList<>()).add(mat[row][col]);
                }
            }

            int[] result = new int[rows * cols];
            int i = 0;

            for (int diagonal = 0; diagonal < diagonalToList.size(); diagonal++) {
                if (diagonal % 2 == 0) {
                    Collections.reverse(diagonalToList.get(diagonal));
                }

                for (int val : diagonalToList.get(diagonal)) {
                    result[i++] = val;
                }
            }

            return result;
        }

    }



    class Solution2 {
        public int[] findDiagonalOrder(int[][] mat) {
            int[][] dirs = {{-1, 1}, {1, -1}};

            int rows = mat.length;
            int cols = mat[0].length;
            int[] result = new int[rows * cols];

            int row = 0;
            int col = 0;
            int dir = 0;

            for (int i = 0; i < result.length; i++) {
                result[i] = mat[row][col];

                int nextRow = row + dirs[dir][0];
                int nextCol = col + dirs[dir][1];

                if (dir == 0) {
                    if (nextRow < 0 && nextCol < cols) {
                        nextRow = 0;
                        nextCol = col + 1;
                        dir = (dir + 1) % 2;
                    } else if (nextCol == cols) {
                        nextRow = row + 1;
                        nextCol = col;
                        dir = (dir + 1) % 2;
                    }
                } else {
                    if (nextRow == rows) {
                        nextCol = col + 1;
                        nextRow = row;
                        dir = (dir + 1) % 2;
                    } else if (nextCol < 0) {
                        nextRow = row + 1;
                        nextCol = col;
                        dir = (dir + 1) % 2;
                    }
                }

                row = nextRow;
                col = nextCol;
            }

            return result;
        }
    }

}
