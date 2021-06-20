package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 9:19 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q157ReadNCharactersGivenRead4 {

    /**
     * The read4 API is defined in the parent class Reader4.
     *     int read4(char[] buf4);
     */

    /**

     solution: just create variable: copied and buf4

     */

    class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        public int read(char[] buf, int n) {
            char[] buf4 = new char[4];
            int copied = 0;

            while (copied < n) {
                int read = read4(buf4);
                if (read == 0) {
                    break;
                }

                int actual = Math.min(n - copied, read);
                System.arraycopy(buf4, 0, buf, copied, actual);
                copied += actual;
            }

            return copied;
        }

    }
    
    class Reader4 {
        public int read4(char[] buf4) {
            return -1;
        }
    }

}
