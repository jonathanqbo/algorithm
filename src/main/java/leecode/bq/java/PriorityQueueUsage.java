package leecode.bq.java;

import java.util.PriorityQueue;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/31/20 9:47 PM
 */
public class PriorityQueueUsage {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(100);
        pq.offer(10);
        pq.offer(88);

        System.out.println(pq.contains(88));

        while (!pq.isEmpty()) {
            // 10 ==> 88 ==> 100
            System.out.println(pq.poll());
        }


    }

}
