package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/14/21 11:49 PM
 */
public class Q348DesignTicTacToe {

    /**
     * Runtime: 4 ms, faster than 53.13% of Java online submissions for Design Tic-Tac-Toe.
     * Memory Usage: 42 MB, less than 61.78% of Java online submissions for Design Tic-Tac-Toe.
     */
    class TicTacToe {
        int[] rows;
        int[] cols;
        int diagonal;
        int antidiagonal;
        int n;

        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            rows = new int[n];
            cols = new int[n];
            this.n = n;
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            // to simplify the player distinguish
            int toAdd = player == 2 ? -1 : 1;

            rows[row] += toAdd;
            cols[col] += toAdd;

            if (row == col) {
                diagonal += toAdd;
            }
            // "else" won't work since the center(row, col) shared in diagonal and antidiagonal
            if (row + col == n - 1) {
                antidiagonal += toAdd;
            }

            if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal) == n || Math.abs(antidiagonal) == n) {
                return player;
            }

            return 0;
        }
    }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

}
