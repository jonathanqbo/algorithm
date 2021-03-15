package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/11/21 10:03 AM
 */
public class Q289GameofLife {

    /**
     * solution: use middle value other than 0/1 to represent the state change, so we can know it's original value.
     *
     * NOTE: this question looks for in-place update and need be "simultaneously" based on origin array.
     * the KEY is how to get better space complexity.
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Game of Life.
     * Memory Usage: 37.7 MB, less than 16.65% of Java online submissions for Game of Life.
     *
     */
    static class Solution {

        static final int[][] DIRECTIONS = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

        public void gameOfLife(int[][] board) {
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[0].length; c++) {
                    int liveNeighbors = 0;
                    for (int[] dir : DIRECTIONS) {
                        int neighborRow = r + dir[0];
                        int neighborCol = c + dir[1];

                        // 1 and -1 represent live neighbor, -1 means it's live, but dead in next state
                        if (neighborRow >= 0 && neighborRow < board.length &&
                                neighborCol >= 0 && neighborCol < board[0].length &&
                                Math.abs(board[neighborRow][neighborCol]) == 1) {
                            liveNeighbors++;
                        }
                    }

                    if (board[r][c] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                        // live to dead
                        board[r][c] = -1;
                    } else if (board[r][c] == 0 && liveNeighbors == 3) {
                        // dead to live
                        board[r][c] = 2;
                    }
                }
            }

            // change state -1 and 2 to final state value 0 and 1
            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[0].length; c++) {
                    if (board[r][c] == -1) {
                        board[r][c] = 0;
                    } else if (board[r][c] == 2) {
                        board[r][c] = 1;
                    }
                }
            }
        }
    }

}
