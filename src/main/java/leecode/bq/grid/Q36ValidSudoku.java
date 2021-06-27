package leecode.bq.grid;

/**
 * <b> </b>
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * Example 1:
 *
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/12/21 11:20 PM
 */
public class Q36ValidSudoku {

    /**

     solution: Map for each row, col, box. then loop all cells and keep track each Map

     KEY: how to calculate box index from row/col: row/3 * 3 + col/3

     Note: this problem doesnt require each row/col/box has to have num 1-9.

     */
    class Solution {

        public boolean isValidSudoku(char[][] board) {
            boolean[][] rows = new boolean[9][9];
            boolean[][] cols = new boolean[9][9];
            boolean[][] boxs = new boolean[9][9];

            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board[row][col] == '.') {
                        continue;
                    };

                    // note: here is 1, not 0
                    int num = board[row][col] - '1';
                    if (rows[row][num] == true || cols[col][num] == true || boxs[row / 3 * 3 + col / 3][num] == true) {
                        return false;
                    }

                    rows[row][num] = true;
                    cols[col][num] = true;
                    boxs[row / 3 * 3 + col / 3][num] = true;
                }
            }

            return true;
        }

    }

}
