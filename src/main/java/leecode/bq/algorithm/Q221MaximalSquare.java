package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/28/21 11:39 AM
 */
public class Q221MaximalSquare {

    /**
     * solution 1: DP - Bottom up
     *
     * dp[i][j]: square width which right bottom is i, j.
     * dp[i][j] = Min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
     *
     * Runtime: 4 ms, faster than 88.37% of Java online submissions for Maximal Square.
     * Memory Usage: 42 MB, less than 81.11% of Java online submissions for Maximal Square.
     *
     */
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;

            int maxSquareWidth = 0;
            // Trick: increase dp size by 1, to avoid if-else check on edge cases
            int[][] dp = new int[rows + 1][cols + 1];
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    // note: char array
                    if (matrix[i-1][j-1] == '0') {
                        continue;
                    }

                    // KEY: dp[i][j] = Min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxSquareWidth = Math.max(dp[i][j], maxSquareWidth);
                }
            }

            return maxSquareWidth * maxSquareWidth;
        }
    }

}
