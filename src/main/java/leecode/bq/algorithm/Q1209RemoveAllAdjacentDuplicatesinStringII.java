package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/6/21 5:39 PM
 */
public class Q1209RemoveAllAdjacentDuplicatesinStringII {


    /**
     * solution 1: two pointers
     *
     * Runtime: 3 ms, faster than 98.18% of Java online submissions for Remove All Adjacent Duplicates in String II.
     * Memory Usage: 38.9 MB, less than 90.64% of Java online submissions for Remove All Adjacent Duplicates in String II.
     *
     */
    class Solution1 {

        char[] chars;
        int length;
        int k;

        public String removeDuplicates(String s, int k) {
            this.chars = s.toCharArray();
            this.length = chars.length;
            this.k = k;

            while (true) {
                if (!remove()) {
                    break;
                }
            }

            return new String(chars, 0, length);
        }

        private boolean remove() {
            int read = 0, write = 0;
            int count = 0;
            while (read < length) {
                if (read > 0 && chars[read] == chars[read - 1]) {
                    count++;
                } else {
                    count = 1;
                }

                chars[write++] = chars[read++];
                if (count == k) {
                    write -= k;
                }
            }

            if (this.length != write) {
                this.length = write;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * solution 2: optimized solution 1: two points with counts
     *
     * Runtime: 3 ms, faster than 98.18% of Java online submissions for Remove All Adjacent Duplicates in String II.
     * Memory Usage: 39.1 MB, less than 85.32% of Java online submissions for Remove All Adjacent Duplicates in String II.
     *
     */
    class Solution2 {

        public String removeDuplicates(String s, int k) {
            char[] chars = s.toCharArray();
            // KEY: use to keep count of chars[i]
            int[] counts = new int[chars.length];

            int write = 0, read = 0;
            while (read < chars.length) {
                chars[write] = chars[read];

                // KEY: check index of WRITE instead of READ
                if (write > 0 && chars[write] == chars[write - 1]) {
                    counts[write] = counts[write -1] + 1;

                    if (counts[write] == k) {
                        write -= k;
                    }
                } else {
                    counts[write] = 1;
                }

                write++;
                read++;
            }

            return new String(chars, 0, write);
        }

    }

    /**
     * solution 4: directly build with StringBuilder, instead of using char[] in solution 1/2.
     *
     * Runtime: 10 ms, faster than 61.17% of Java online submissions for Remove All Adjacent Duplicates in String II.
     * Memory Usage: 42.4 MB, less than 12.13% of Java online submissions for Remove All Adjacent Duplicates in String II.
     */
    class Solution4 {

        public String removeDuplicates(String s, int k) {
            StringBuilder sb = new StringBuilder();

            char[] chars = s.toCharArray();
            // KEY: use to keep count of chars[i]
            int[] counts = new int[chars.length];

            int read = 0;
            while (read < chars.length) {
                sb.append(chars[read]);

                // KEY: everything is based on the sb stringbuilder.
                int lastIndex = sb.length() - 1;
                if (lastIndex > 0 && sb.charAt(lastIndex) == sb.charAt(lastIndex - 1)) {
                    counts[lastIndex] = counts[lastIndex - 1] + 1;

                    if (counts[lastIndex] == k) {
                        // note: here the fromIdex is lastIndex - k + 1
                        sb.delete(lastIndex - k + 1, lastIndex + 1);
                    }
                } else {
                    counts[lastIndex] = 1;
                }

                read++;
            }

            return sb.toString();
        }

    }

    /**
     * solution 3: different idea than other solutions
     * it builds StingBuilder from origin whole string, instead of append it char by char.
     *
     * Runtime: 4 ms, faster than 92.75% of Java online submissions for Remove All Adjacent Duplicates in String II.
     * Memory Usage: 39.2 MB, less than 79.21% of Java online submissions for Remove All Adjacent Duplicates in String II.
     */
    class Solution3 {
        public String removeDuplicates(String s, int k) {
            StringBuilder sb = new StringBuilder(s);
            int count[] = new int[sb.length()];
            for (int i = 0; i < sb.length(); ++i) {
                if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                    count[i] = 1;
                } else {
                    count[i] = count[i - 1] + 1;
                    if (count[i] == k) {
                        sb.delete(i - k + 1, i + 1);
                        i = i - k;
                    }
                }
            }
            return sb.toString();
        }
    }



}
