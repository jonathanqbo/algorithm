package leecode.bq.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/7/21 8:48 PM
 */
public class Q973KClosestPointstoOrigin {

    /**
     * solution 1: Priority Queue
     *
     * Runtime: 29 ms, faster than 37.79% of Java online submissions for K Closest Points to Origin.
     * Memory Usage: 49 MB, less than 19.09% of Java online submissions for K Closest Points to Origin.
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(K + 1, (point1, point2) ->
                Integer.compare(distance(point2), distance(point1)));

        for (int[] point: points) {
            pq.offer(point);

            if (pq.size() > K) {
                pq.poll();
            }
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }


    /**
     * solution 2: quick select
     *
     * Runtime: 3 ms, faster than 98.55% of Java online submissions for K Closest Points to Origin.
     * Memory Usage: 47.9 MB, less than 44.91% of Java online submissions for K Closest Points to Origin.
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest2(int[][] points, int K) {
        quickSelect(points, 0, points.length - 1, K);

        return Arrays.copyOfRange(points, 0, K);
    }

    private void quickSelect(int[][] points, int from, int to, int k) {
        if (from >= to) {
            return;
        }

        int mid = partition(points, from, to);
        int leftLength = mid - from + 1;

        if (leftLength == k) {
            return;
        }

        if (leftLength < k) {
            quickSelect(points, mid + 1, to, k - leftLength);
        } else if (leftLength > k) {
            quickSelect(points, from, mid - 1, k);
        }
    }

    private int partition(int[][] points, int from, int to) {
        int pivotIndex = to;
        int pivot = distance(points[pivotIndex]);

        int i = from;
        for (int j = from; j <= to; j++) {
            if (distance(points[j]) < pivot) {
                swap(points, i, j);
                i++;
            }
        }

        swap(points, i, pivotIndex);

        return i;
    }

    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

}
