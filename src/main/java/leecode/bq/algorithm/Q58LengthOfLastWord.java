package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
 * Memory Usage: 36.7 MB, less than 99.52% of Java online submissions for Length of Last Word.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/24/20 9:04 PM
 */
public class Q58LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int start = s.length() - 1;
        while (start >= 0 && s.charAt(start) == ' ')
            start--;

        if (start < 0)
            return 0;

        int length = 0;
        while (start >= 0 && s.charAt(start) != ' ') {
            length++;
            start--;
        }

        return length;
    }

    public static void main(String[] args) {
        Q58LengthOfLastWord q = new Q58LengthOfLastWord();
        q.lengthOfLastWord("Hello world");
    }
}
