package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/14/21 10:33 PM
 */
public class Q344ReverseString {

    /**
     * solution: 2 pointers
     *
     * Runtime: 1 ms, faster than 95.89% of Java online submissions for Reverse String.
     * Memory Usage: 46.1 MB, less than 38.69% of Java online submissions for Reverse String.
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left++;
            right--;
        }
    }

}
