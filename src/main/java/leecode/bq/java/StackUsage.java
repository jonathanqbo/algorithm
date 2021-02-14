package leecode.bq.java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * <b> </b>
 *
 * {@link java.util.Stack} is not preferred in java, instead use {@link java.util.Deque}
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/4/21 11:03 PM
 */
public class StackUsage {

    public static void main(String[] args) {
        StackUsage su = new StackUsage();
        su.basicWithLinkedList();
    }

    private void basicWithLinkedList() {
        Deque<Integer> stack = new LinkedList<>();

        IntStream.range(0, 10).forEach(stack::push);

        while (!stack.isEmpty()) {
            System.out.println(stack.peek() + "/" + stack.pop());
        }
    }

    private void basicWithArrayList() {
        Deque<Integer> statck = new ArrayDeque<>();
    }

}
