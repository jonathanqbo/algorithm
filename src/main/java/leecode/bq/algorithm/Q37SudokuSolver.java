package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 8:44 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */

/**

 solution: similar like N-Queen problem

 key:
 use boolean[row][num] to track if num in row
 use boolean[col][num] to track if num in column
 use boolean[box][num] to track if num in box
 * if found solution, skip the bracktracking process since we do in-place modification on board

 KEY: how to get box from row, col

 note: be carefore, the num is 1 based, and we use it in 0 based in array.

 */

public class Q37SudokuSolver {
    static final char EMPTY = '.';

    int n = 0;
    boolean[][] numsInRows = null;
    boolean[][] numsInCols = null;
    boolean[][] numsInBoxs = null;

    char[][] board = null;

    public void solveSudoku(char[][] board) {
        n = board.length;
        numsInRows = new boolean[n][n + 1]; // num is 1 based: 1-9
        numsInCols = new boolean[n][n + 1];
        numsInBoxs = new boolean[n][n + 1];
        this.board = board;

        init();

        dfs(0, 0);
    }

    private boolean dfs(int row, int col) {
        if (row >= n) {
            return true;
        }

        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol >= n) {
            nextRow++;
            nextCol = 0;
        }

        // if already has num in the position, go to next position, no need to do try & backtracking
        if (board[row][col] != EMPTY) {
            return dfs(nextRow, nextCol);
        }

        // note: <= n
        for (int i = 1; i <= n; i++) {
            if (isNumValid(i, row, col)) {
                putNumInPosition(i, row, col);

                // key: if found solution, don't backtrack to keep the result since we do inplace modification on board
                if (dfs(nextRow, nextCol)) {
                    return true;
                }

                clearNumInPosition(i, row, col);
            }
        }

        return false;
    }

    private boolean isNumValid(int num, int row, int col) {
        return !numsInRows[row][num] && !numsInCols[col][num] && !numsInBoxs[getBoxIdx(row, col)][num];
    }

    private void putNumInPosition(int num, int row, int col) {
        // note: remember forse cast to char
        board[row][col] = (char)('0' + num);

        numsInRows[row][num] = true;
        numsInCols[col][num] = true;
        numsInBoxs[getBoxIdx(row, col)][num] = true;
    }

    private void clearNumInPosition(int num, int row, int col) {
        board[row][col] = EMPTY;

        numsInRows[row][num] = false;
        numsInCols[col][num] = false;
        numsInBoxs[getBoxIdx(row, col)][num] = false;
    }

    private void init() {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char c = board[row][col];
                if (c != EMPTY) {
                    int num = c - '0';

                    numsInRows[row][num] = true;
                    numsInCols[col][num] = true;
                    numsInBoxs[getBoxIdx(row, col)][num] = true;
                }
            }
        }
    }

    private int getBoxIdx(int row, int col) {
        return row / 3 * 3 + col / 3;
    }

}