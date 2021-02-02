package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/20/21 8:48 PM
 */
public class Q118PascalsTriangle {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
     * Memory Usage: 36.8 MB, less than 64.95% of Java online submissions for Pascal's Triangle.
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList(numRows + 1);
        if (numRows <= 0) {
            return result;
        }

        List<Integer> row1 = new ArrayList(1);
        row1.add(1);
        result.add(row1);

        List<Integer> rowPre = row1;
        for (int i = 1; i < numRows; i++) {
            List<Integer> rowi = new ArrayList(i + 1);
            rowi.add(1);

            for (int j = 0; j < rowPre.size() - 1; j++) {
                rowi.add(rowPre.get(j) + rowPre.get(j + 1));
            }

            rowi.add(1);

            result.add(rowi);
            rowPre = rowi;
        }

        return result;
    }

}
