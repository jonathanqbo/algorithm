package leecode.bq.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 9:58 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q339NestedListWeightSum {

    /**
     * solution 1: recursion
     * <p>
     * see recursion function below
     * <p>
     * ------
     * <p>
     * solution 2: BFS
     * <p>
     * key: Queue<List<NestedInteger>> queue on list instead of NestedInteger.
     */
    class Solution {

        public int depthSum(List<NestedInteger> nestedList) {
            return depthSumByLevel(1, nestedList);
        }

        private int depthSumByLevel(int level, List<NestedInteger> nestedList) {
            int sum = 0;

            for (NestedInteger item : nestedList) {
                if (item.isInteger()) {
                    sum += item.getInteger() * level;
                } else {
                    sum += depthSumByLevel(level + 1, item.getList());
                }
            }

            return sum;
        }

    }


    class Solution1 {

        public int depthSum(List<NestedInteger> nestedList) {
            return depthSumByLevel(nestedList, 1);
        }

        private int depthSumByLevel(List<NestedInteger> list, int level) {
            int sum = 0;

            for (NestedInteger node : list) {
                if (node.isInteger()) {
                    sum += node.getInteger() * level;
                } else {
                    sum += depthSumByLevel(node.getList(), level + 1);
                }
            }

            return sum;
        }

    }


    class Solution2 {

        public int depthSum(List<NestedInteger> nestedList) {
            int sum = 0;

            Queue<List<NestedInteger>> queue = new LinkedList<>(); // KEY: Queue on List<NestedInteger>
            queue.offer(nestedList);

            int level = 1;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    List<NestedInteger> nodes = queue.poll();

                    for (NestedInteger node : nodes) {
                        if (node.isInteger()) {
                            sum += node.getInteger() * level;
                        } else {
                            queue.offer(node.getList());
                        }
                    }
                }

                level++;
            }

            return sum;
        }

    }

    class NestedInteger {

        public boolean isInteger() {
            return false;
        }

        public List<NestedInteger> getList() {
            return null;
        }

        public int getInteger() {
            return 0;
        }
    }

}
