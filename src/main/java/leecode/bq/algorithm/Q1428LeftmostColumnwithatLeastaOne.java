package leecode.bq.algorithm;

import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/7/21 6:09 PM
 */
public class Q1428LeftmostColumnwithatLeastaOne {

    /**
     * solution: BinarySearch based on former Binary Search result
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Leftmost Column with at Least a One.
     * Memory Usage: 39.9 MB, less than 34.94% of Java online submissions for Leftmost Column with at Least a One.
     *
     */
    class Solution {
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            List<Integer> dim = binaryMatrix.dimensions();
            int rows = dim.get(0);
            int cols = dim.get(1);

            // keep tracking the index of left most 1
            int minCol = cols;
            for (int row = 0; row < rows; row++) {
                int curMinCol = binarySearch(row, minCol, binaryMatrix);
                if (curMinCol >= 0) {
                    minCol = curMinCol;
                }
            }

            return minCol == cols ? -1 : minCol;
        }

        private int binarySearch(int row, int length, BinaryMatrix binaryMatrix) {
            int left = 0, right = length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int val = binaryMatrix.get(row, mid);
                if (val == 0) {
                    // left is the first 1
                    left = mid + 1;
                } else {
                    // right is the first 0
                    right = mid - 1;
                }
            }

            return left == length ? -1 : left;
        }
    }

    class BinaryMatrix {

        public int get(int row, int mid) {
            return 1;
        }

        public List<Integer> dimensions() {
            return null;
        }
    }

}
