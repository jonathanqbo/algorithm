package leecode.bq.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/15/21 11:00 AM
 */
public class ListUsage {

    public static void main(String[] args) {
        createEmptyListWithType();
        arrayAsList();
        linkedListPeekLast();
    }

    public static List<String> createEmptyListWithType() {
        // unmodifiable
//        return Collections.<String>emptyList();
        List<String> list = Collections.emptyList();
//        list.add("a"); // UnsupportedOperationException
        return list;
    }

    public static List<String> arrayAsList() {
        // modifiable, but not support "add" operation
        List<String> list = Arrays.asList("a", "b");
        // UnsupportedOperationException
//        list.add("c");
        return list;
    }

    public static void linkedListPeekLast() {
        LinkedList<String> list = new LinkedList<>();
        // will return null
        list.peekLast();
        // will throw NoSuchElementException
//        list.getLast();
    }
}
