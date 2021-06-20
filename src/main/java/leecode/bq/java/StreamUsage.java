package leecode.bq.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 3/20/21 9:07 PM
 *
 * @author : jonathan.q.bo@gmail.com
 * @since : V1.0
 */
public class StreamUsage {

    public static void main(String[] args) {
        maxList();
    }

    private static void maxList() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 6, 6, 6, 6);

        // by Collect: collect won't create new accumulator
        ArrayList<Integer> result = nums.stream().collect(ArrayList<Integer>::new,
                (list, num) -> {
                    if (!list.isEmpty() && num > list.get(0)) {
                        list.clear();
                        list.add(num);
                    } else if (list.isEmpty() || num == list.get(0)) {
                        list.add(num);
                    }
                },
                List::addAll
        );

        // by reduce: every accumulate and combine return new one
        ArrayList<Integer> result2 = nums.stream().reduce(new ArrayList<Integer>(),
                (list, num) -> {
                    if (list.isEmpty() || list.get(0) == num) {
                        list.add(num);
                    } else if (!list.isEmpty() && num > list.get(0)) {
                        ArrayList<Integer> newlist = new ArrayList<>();
                        newlist.add(num);
                        return newlist;
                    }
                    return list;
                },
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                });

        result.forEach(System.out::println);
        result2.forEach(System.out::println);
    }

}
