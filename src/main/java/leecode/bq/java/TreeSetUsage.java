package leecode.bq.java;

import java.util.TreeSet;

/**
 * <b> </b>
 *
 * TreeSet is ordered.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/31/20 9:30 PM
 */
public class TreeSetUsage {

    public static void main(String[] args) {
        TreeSet<Integer> ts  = new TreeSet<>();

        ts.add(100);
        ts.add(1);
        ts.add(88);
        ts.add(18);
        ts.add(66);

        // [1, 18, 66, 88, 100]
        System.out.println(ts);
        // 1 100
        System.out.println(ts.pollFirst() + " " + ts.pollLast());
    }
}
