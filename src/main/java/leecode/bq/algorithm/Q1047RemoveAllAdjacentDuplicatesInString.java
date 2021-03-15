package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/6/21 5:40 PM
 */
public class Q1047RemoveAllAdjacentDuplicatesInString {

    /**
     * solution 1: two pointers
     *
     * Runtime: 4 ms, faster than 93.62% of Java online submissions for Remove All Adjacent Duplicates In String.
     * Memory Usage: 39.7 MB, less than 54.29% of Java online submissions for Remove All Adjacent Duplicates In String.
     *
     */
    class Solution {
        char[] chars;
        int length;

        public String removeDuplicates(String S) {
            this.chars = S.toCharArray();
            this.length = chars.length;

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

                if (count == 2) {
                    write -= 2;
                }
            }

            if (write != this.length) {
                this.length = write;
                return true;
            }
            return false;
        }

    }

    /**
     * solution 2: stack (StringBuilder act as stack)
     *
     * Runtime: 6 ms, faster than 87.21% of Java online submissions for Remove All Adjacent Duplicates In String.
     * Memory Usage: 39.5 MB, less than 64.65% of Java online submissions for Remove All Adjacent Duplicates In String.
     *
     */
    class Solution2 {

        public String removeDuplicates(String S) {
            StringBuilder sb = new StringBuilder();

            for (char c : S.toCharArray()) {
                int lastIndex = sb.length() - 1;
                if (lastIndex >= 0 && sb.charAt(lastIndex) == c) {
                    sb.deleteCharAt(lastIndex);
                } else {
                    sb.append(c);
                }
            }

            return sb.toString();
        }

    }


    /**
     * solution 3: More concise than solution 1
     *
     * Runtime: 3 ms, faster than 99.72% of Java online submissions for Remove All Adjacent Duplicates In String.
     * Memory Usage: 39.4 MB, less than 74.65% of Java online submissions for Remove All Adjacent Duplicates In String.
     *
     */
    class Solution3 {
        public String removeDuplicates(String S) {
            char[] chars = S.toCharArray();
            int length = chars.length;

            int read = 0, write = 0;
            while (read < length) {
                chars[write] = chars[read];

                // KEY: write always point to next positon to be next different value
                // so check [write] and [write - 1], will trace back all duplicate chars
                if (write > 0 && chars[write] == chars[write - 1]) {
                    write -= 2;
                }

                read++;
                write++;
            }

            return new String(chars, 0, write);
        }
    }


}
