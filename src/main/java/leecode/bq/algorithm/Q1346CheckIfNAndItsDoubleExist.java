package leecode.bq.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/30/20 11:30 PM
 */
public class Q1346CheckIfNAndItsDoubleExist {

    /**
     * key: do it in one loop
     *
     * Runtime: 1 ms, faster than 98.41% of Java online submissions for Check If N and Its Double Exist.
     * Memory Usage: 38.2 MB, less than 99.18% of Java online submissions for Check If N and Its Double Exist.
     *
     * @param arr
     * @return
     */
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet();
        int zeroAmount = 0;
        for (int v: arr) {
            if (v % 2 == 0 && set.contains(v / 2)) {
                return true;
            } else if (set.contains(v * 2)) {
                return true;
            }else {
                set.add(v);
            }
        }

        return false;
    }
}
