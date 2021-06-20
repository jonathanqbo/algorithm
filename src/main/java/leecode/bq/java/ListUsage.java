package leecode.bq.java;

import java.util.*;

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
        deleteItem();
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

    public static void deleteItem() {
        // remove first item in for-loop
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item); // Good
            }
        }
        list.forEach(System.out::println);

        // remove second item in for-loop
        List<String> list2 = new ArrayList<String>();
        list2.add("1");
        list2.add("2");
        for (String item : list2) {
            if ("2".equals(item)) {
                //list2.remove(item); // ConcurrentModificationException
            }
        }
        list2.forEach(System.out::println);

        // remove second item in iterator
        List<String> list3 = new ArrayList<String>();
        list3.add("1");
        list3.add("2");
        Iterator<String> iter = list3.listIterator();
        while (iter.hasNext()) {
            if (iter.next() == "2") {
                iter.remove();
            }
        }
        list3.forEach(System.out::println);

        // removIf
        List<String> list4 = new ArrayList<String>();
        list4.add("1");
        list4.add("2");
        list4.removeIf(i -> i == "2");
        list4.forEach(System.out::println);
    }
}
