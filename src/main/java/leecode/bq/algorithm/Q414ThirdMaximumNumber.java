package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/31/20 9:45 PM
 */
public class Q414ThirdMaximumNumber {

    /**
     * solution 1: TreeSet
     *
     * Runtime: 3 ms, faster than 45.70% of Java online submissions for Third Maximum Number.
     * Memory Usage: 38.4 MB, less than 95.40% of Java online submissions for Third Maximum Number.
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet();
        for (int num : nums)
            if (set.add(num) && set.size() > 3)
                set.pollFirst();

        return set.size() > 2 ? set.pollFirst() : set.pollLast();
    }

    /**
     * solution 2: PriorityQueue
     *
     * Runtime: 2 ms, faster than 67.16% of Java online submissions for Third Maximum Number.
     * Memory Usage: 39 MB, less than 41.02% of Java online submissions for Third Maximum Number.
     *
     * @param nums
     * @return
     */
    public int thirdMax2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue(4);
        for (int num : nums) {
            if (pq.contains(num)) continue;

            if (pq.size() < 3) {
                pq.offer(num);
            } else if ( num > pq.peek() && pq.offer(num) && pq.size() > 3) {
                pq.poll();
            }
        }

        if (pq.size() == 2)
            pq.poll();

        return pq.poll();
    }

    /**
     * solution 3: HashSet
     *
     * Runtime: 4 ms, faster than 37.02% of Java online submissions for Third Maximum Number.
     * Memory Usage: 38.6 MB, less than 89.59% of Java online submissions for Third Maximum Number.
     *
     * @param nums
     * @return
     */
    public int thirdMax3(int[] nums) {
        Set<Integer> max3 = new HashSet();

        for (int num : nums) {
            max3.add(num);

            if (max3.size() > 3) {
                max3.remove(Collections.min(max3));
            }
        }

        if (max3.size() == 3)
            return Collections.min(max3);

        return Collections.max(max3);
    }

    /**
     * solution 4: raw array
     *
     * Runtime: 1 ms, faster than 88.95% of Java online submissions for Third Maximum Number.
     * Memory Usage: 39.1 MB, less than 21.46% of Java online submissions for Third Maximum Number.
     *
     * @param nums
     * @return
     */
    public int thirdMax4(int[] nums) {
        Max3 max3 = new Max3();

        for (int num: nums) {
            max3.add(num);
        }

        if (max3.size() >= 3)
            return max3.min();

        return max3.max();
    }

    class Max3 {
        int[] values = new int[3];
        int size = 0;

        public void add(int num) {
            if (contains(num))
                return;

            if (size < 3) {
                values[size] = num;
                size++;
                return;
            }

            if (min() < num)
                replaceMin(num);
        }

        public boolean contains(int num) {
            for (int i = 0; i < size; i++) {
                if (values[i] == num)
                    return true;
            }

            return false;
        }

        public int size() {
            return size;
        }

        public Integer min() {
            if (size == 0)
                return null;

            return values[minIndex()];
        }

        public Integer max() {
            if (size == 0)
                return null;

            return values[maxIndex()];
        }

        private void replaceMin(int num) {
            int minIndex = minIndex();
            values[minIndex] = num;
        }

        private int minIndex() {
            int min = values[0];
            int j = 0;
            for (int i = 1; i < size; i++) {
                if (values[i] < min) {
                    min = values[i];
                    j = i;
                }
            }

            return j;
        }

        private int maxIndex() {
            int max = values[0];
            int j = 0;
            for (int i = 1; i < size; i++) {
                if (values[i] > max) {
                    max = values[i];
                    j = i;
                }
            }

            return j;
        }
    }
}
