package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/6/21 10:38 PM
 */
public class Q79WordSearch {


    /**
     * solution: DFS + backtracking
     *
     * (This runtime doesn't make sense, since there is no solution that's faster)
     * Runtime: 121 ms, faster than 8.07% of Java online submissions for Word Search.
     * Memory Usage: 46.9 MB, less than 9.71% of Java online submissions for Word Search.
     *
     */
    class Solution {
        // static final int[][] MOVES = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        public boolean exist(char[][] board, String word) {
            int rows = board.length;
            int cols = board[0].length;

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (board[row][col] == word.charAt(0) && backtrack(board, row, col, word, 0)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean backtrack(char[][] board, int row, int col, String word, int idx) {
            if (word.isEmpty() || idx == word.length()) {
                return true;
            }

            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '#' | word.charAt(idx) != board[row][col]) {
                return false;
            }

            // mark as visited
            board[row][col] = '#';

            // for (int[] move: MOVES) {
            //     if (backtrack(board, row + move[0], col + move[1], word, idx + 1)) {
            //         return true;
            //     }
            // }
            boolean find = backtrack(board, row + 1, col, word, idx + 1) ||
                    backtrack(board, row - 1, col, word, idx + 1) ||
                    backtrack(board, row, col + 1, word, idx + 1) ||
                    backtrack(board, row, col - 1, word, idx + 1);

            // backtrack
            board[row][col] = word.charAt(idx);

            return find;
        }

    }

}
