package leecode.bq.algorithm;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/13/21 9:03 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q295FindMedianFromDataStream {

    class MedianFinder {
        // low -> high, keep the big half
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        // high -> low, keep the small half
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        /** initialize your data structure here. */
        public MedianFinder() {

        }

        public void addNum(int num) {
            maxQueue.offer(num);
            minQueue.offer(maxQueue.poll());
            if(minQueue.size() > maxQueue.size()) {
                maxQueue.offer(minQueue.poll());
            }
        }

        public double findMedian() {
            if (minQueue.size() < maxQueue.size()) {
                return maxQueue.peek();
            } else {
                return ((double) maxQueue.peek() + minQueue.peek()) / 2;
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

}