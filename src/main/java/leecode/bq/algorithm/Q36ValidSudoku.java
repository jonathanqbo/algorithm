package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/12/21 11:20 PM
 */
public class Q36ValidSudoku {

    /**
     * solution: one iteration and record each row / column / box.
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Sudoku.
     * Memory Usage: 39 MB, less than 79.72% of Java online submissions for Valid Sudoku.
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int num = board[i][j] - '1';

                // row
                if (rows[i][num]) {
                    return false;
                } else {
                    rows[i][num] = true;
                }

                // column
                if (cols[j][num]) {
                    return false;
                } else {
                    cols[j][num] = true;
                }

                // box
                // key: cal box index by row index and col index
                int boxIndex = (i / 3) * 3 + j / 3;
                if (boxes[boxIndex][num]) {
                    return false;
                } else {
                    boxes[boxIndex][num] = true;
                }
            }
        }

        return true;
    }

}
