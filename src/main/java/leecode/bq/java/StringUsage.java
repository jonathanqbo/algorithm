package leecode.bq.java;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/24/21 11:08 PM
 */
public class StringUsage {

    public static void main(String[] args) {
        String[] spaceSplit = "hello world".split(" "); // Also Good
        System.out.println(String.join(" ", spaceSplit));
        spaceSplit = "hello world".split("\\s"); // Good
        System.out.println(String.join(" ", spaceSplit));

        String[] dotSplit = "hello.world.world".split("\\.");
//        String[] dotSplit = "hello.world.world".split("."); // WONT WORK!
        System.out.println(String.join(".", dotSplit));


        // split with limit (threshhold)
        String[] splitWithLimit = "hello world hah xixi hoho".split(" ", 2);
        System.out.println(String.join("+", splitWithLimit));
        splitWithLimit = "hello world hah xixi hoho".split(" ", 8);
        System.out.println(String.join("+", splitWithLimit));


        // substring with length (last index + 1), will return empty ""
        String emptySubStr = "hello".substring("hello".length());
        System.out.println("empty|" + emptySubStr + "|empty");
    }

}
