package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:24 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q766ToeplitzMatrix {

    /**

     solution 1:  Group by Category

     KEY: two coordinates are on the same diagonal if and only if r1 - c1 == r2 - c2

     -------

     solution 2: compare with TOP-LEFT neighbor

     */

    class Solution {

        public boolean isToeplitzMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i > 0 && j > 0 && matrix[i][j] != matrix[i - 1][j - 1]) {
                        return false;
                    }
                }
            }

            return true;
        }

    }

}
