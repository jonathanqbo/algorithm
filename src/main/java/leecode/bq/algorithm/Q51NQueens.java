package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:45 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */

import java.util.ArrayList;
import java.util.List;

/**

 solution: dfs + backtracking

 KEY:
 1. to get next valid position effeciently, use boolean[] to track if row, col, diagonal, antidiagonal are occupied
 2. to get diagonal from row, col:
 same diagonal: row + col == const
 same anti diagonal: row - col == const
 3. to keep all the occupied position, use int[] positions: positions[row] = col


 @see 37. Sudoku Solver

 */
public class Q51NQueens {

    boolean[] occupiedRow = null;
    boolean[] occupiedCol = null;
    boolean[] occupiedDiagonal = null;
    boolean[] occupiedAntiDiagonal = null;
    List<List<String>> result = new ArrayList<>();
    int[] positions = null; // position[row] = col, ie: row to col mapping
    int n = 0;

    public List<List<String>> solveNQueens(int n) {
        occupiedRow = new boolean[n];
        occupiedCol = new boolean[n];
        occupiedDiagonal = new boolean[2 * n - 1];
        occupiedAntiDiagonal = new boolean[2 * n - 1];
        positions = new int[n];
        this.n = n;

        dfs(0);

        return result;
    }

    private void dfs(int row) {
        if (row == n) {
            keepResult();
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValidPosition(row, col)) {
                occupy(row, col);
                dfs(row + 1);
                unoccupy(row, col);
            }
        }
    }

    private boolean isValidPosition(int row, int col) {
        return occupiedRow[row] || occupiedCol[col] || occupiedDiagonal[row + col] || occupiedAntiDiagonal[row - col + n - 1] ? false : true;
    }

    private void occupy(int row, int col) {
        positions[row] = col;

        occupiedRow[row] = true;
        occupiedCol[col] = true;
        occupiedDiagonal[row + col] = true;
        occupiedAntiDiagonal[row - col + n - 1] = true;
    }

    private void unoccupy(int row, int col) {
        positions[row] = 0;

        occupiedRow[row] = false;
        occupiedCol[col] = false;
        occupiedDiagonal[row + col] = false;
        occupiedAntiDiagonal[row - col + n - 1] = false;
    }

    private void keepResult() {
        List<String> oneResult = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();

            for (int col = 0; col < n; col++) {
                if (positions[row] == col) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }

            oneResult.add(sb.toString());
        }

        result.add(oneResult);
    }

}