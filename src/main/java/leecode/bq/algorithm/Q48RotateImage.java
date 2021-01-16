package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/14/21 10:10 PM
 */
public class Q48RotateImage {

    /**
     * solution: transpose + reverse
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
     * Memory Usage: 38.8 MB, less than 94.60% of Java online submissions for Rotate Image.
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose: matrix[i][j] <==> matrix[j][i]
        for (int i = 0; i < n; i++) {
            // only do half
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }

    /**
     * solution 2: rotate
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
     * Memory Usage: 39.2 MB, less than 35.09% of Java online submissions for Rotate Image.
     *
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[n - 1 - j][i];
                // exchange row <-> colmn every step: switch i, j in every step
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

}
