package leecode.bq.java;

import java.util.PriorityQueue;

/**
 * <b> </b>
 *
 * 1. PriorityQueue is implement by Array
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/31/20 9:47 PM
 */
public class PriorityQueueUsage {

    public static void main(String[] args) {
        withPrimitiveValue();
        withObject();
        withObjectInsertOrderXX();
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

    private static void withObjectInsertOrderXX() {
        MyObject o1 = new MyObject("a1", 1);
        MyObject o2 = new MyObject("a2", 1);
        MyObject o3 = new MyObject("a3", 1);

        // return 1 if v1 == v2 to keep the insert order, this is NOT dependable
        PriorityQueue<MyObject> pq = new PriorityQueue<>( (obj1, obj2) -> obj1.value < obj2.value ? -1 : 1);
        pq.offer(o1);
        pq.offer(o2);
        pq.offer(o3);

        pq.remove(o2);
        o2.value = 88;
        pq.offer(o2);

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

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

}
