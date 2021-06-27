package leecode.bq.math;

/**
 * <b> </b>
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/14/21 10:10 PM
 */
public class Q48RotateImage {

    /**
     rotate = transpose + reverse

     transpose: m[i][j] = m[j][i]
     reverse (each row): m[i][j] = m[i][n-j-1]

     KEY:
     transpose: only loop the right-top half cells
     reverse: loop n/2


     clockwise rotate
     ----------------
     first reverse up to down (reverse), then swap the symmetry (transpose)
     1 2 3     7 8 9     7 4 1
     4 5 6  => 4 5 6  => 8 5 2
     7 8 9     1 2 3     9 6 3

     anticlockwise rotate
     ---------------
     first reverse left to right, then swap the symmetry
     1 2 3     3 2 1     3 6 9
     4 5 6  => 6 5 4  => 2 5 8
     7 8 9     9 8 7     1 4 7

     */
    class Solution {

        /** way 1: transpose + reverse left to right*/
        public void rotate(int[][] matrix) {
            transpose(matrix);
            reverseLeftRight(matrix);
        }

        /** way 2: reverse up side down + transpose*/
        public void rotate2(int[][] matrix) {
            reverseUpDown(matrix);
            transpose(matrix);
        }

        private void reverseUpDown(int[][] matrix) {
            int rows = matrix.length, cols = matrix[0].length;

            for (int row = 0; row < rows / 2; row++) {
                for (int col = 0; col < cols; col++) {
                    swap(matrix, row, col, rows - 1 - row, col);
                }
            }
        }

        private void reverseLeftRight(int[][] matrix) {
            int rows = matrix.length, cols = matrix[0].length;

            for (int col = 0; col < cols / 2; col++) {
                for (int row = 0; row < rows; row++) {
                    swap(matrix, row, col, row, cols - 1 - col);
                }
            }
        }

        private void transpose(int[][] matrix) {
            int rows = matrix.length, cols = matrix[0].length;

            for (int row = 0; row < rows; row++) {
                for (int col = row + 1; col < cols; col++) {
                    swap(matrix, row, col, col, row);
                }
            }
        }

        private void swap(int[][] matrix, int row1, int col1, int row2, int col2) {
            int tmp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = tmp;
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
