package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/28/21 4:31 PM
 */
public class Q443StringCompression {

    /**
     * solution: two pointers (read, write)
     *
     * Runtime: 1 ms, faster than 93.08% of Java online submissions for String Compression.
     * Memory Usage: 38.5 MB, less than 79.43% of Java online submissions for String Compression.
     *
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        int write = 0;
        int read = 0; // stop at the last one of same chars
        while (read < chars.length) {
            int length  = 1;
            while (read + 1 < chars.length && chars[read] == chars[read + 1]) {
                read++;
                length++;
            }

            chars[write++] = chars[read];
            if (length > 1) {
                // NOTE: length could be more than 1 digit, such as 100
                for (char c: String.valueOf(length).toCharArray()) {
                    chars[write++] = c;
                }
            }

            // point to next not-same char
            read++;
        }

        return write;
    }

}
