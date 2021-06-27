package leecode.bq.grid;

/**
 * <b> </b>
 *
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * A sudoku solution must satisfy all of the following rules:
 *
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * Explanation: The input board is shown above and the only valid solution is shown below:
 *
 *
 * Created at 6/13/21 8:44 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q37SudokuSolver {
    /**

     solution: similar like N-Queen problem

     Treat as a tree (the path is cell to cell), to find a path that the nodes meet the Sudoku rules.

     cell_0,0
     /  |  \
     2   5   8
     |
     cell_0,1


     key:
     use boolean[row][num] to track if num in row
     use boolean[col][num] to track if num in column
     use boolean[box][num] to track if num in box
     * if found solution, skip the bracktracking process since we do in-place modification on board

     KEY: how to get box from row, col

     note: be carefore, the num is 1 based, and we use it in 0 based in array.

     */

    class Solution {
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

}