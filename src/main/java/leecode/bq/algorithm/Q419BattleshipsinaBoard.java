package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:02 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q419BattleshipsinaBoard {

    class Solution {

        public int countBattleships(char[][] board) {
            int rows = board.length;
            int cols = board[0].length;

            int count = 0;
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (board[row][col] == 'X' &&
                            (row == 0 || board[row - 1][col] != 'X') &&
                            (col == 0 || board[row][col - 1] != 'X')) {
                        count++;
                    }
                }
            }

            return count;
        }

    }

}
