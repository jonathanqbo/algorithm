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
        withPrimitiveValue();
        withObject();
    }

    private static void withPrimitiveValue() {
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

    private static void withObject() {
        MyObject[] objs = {new MyObject("a", 8),
                new MyObject("b", 6), new MyObject("c", 18)};

        PriorityQueue<MyObject> pq = new PriorityQueue<>( (obj1, obj2) -> Integer.compare(obj1.value, obj2.value));
        for(MyObject obj: objs) {
            pq.offer(obj);
        }

        while (!pq.isEmpty()) {
            MyObject ob = pq.poll();
            System.out.println(ob.name + ":" + ob.value);
        }
    }

    static class MyObject {
        String name;
        int value;

        public MyObject(String name, int value) {
            this.name = name;
            this.value = value;
        }
    }

}
