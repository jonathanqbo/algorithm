package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/28/21 11:41 PM
 */
public class Q158ReadNCharactersGivenRead4IICallmultipletimes {

    // cur index of last buffer4
    int i4 = 0;
    // cur length of last buffer4
    int n4 = 0;
    // last buffer4
    char[] buf4 = new char[4];

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n) {
            if (i4 == n4) {
                i4 = 0;
                n4 = read4(buf4);

                if (n4 == 0) {
                    break;
                }
            }

            // the above equals below, but this will give much better performance
            //
            //     int i = 0;
            //     while (i < n && (i4 < n4 || (i4 = 0) < (n4 = read4(buf4))))
            //         buf[i++] = buf4[i4++];
            //     return i;

            buf[i++] = buf4[i4++];
        }

        return i;
    }

    private int read4(char[] buf4) {
        return 0;
    }

}
