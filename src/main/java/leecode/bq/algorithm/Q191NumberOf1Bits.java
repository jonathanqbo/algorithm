package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/19/21 10:27 PM
 */
public class Q191NumberOf1Bits {

    /**
     * solution 1: check each bit by masking by 1 << n
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of 1 Bits.
     * Memory Usage: 36.2 MB, less than 28.55% of Java online submissions for Number of 1 Bits.
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int ans = 0;
        // int has 32 bit: -2(31) -> 2(31) - 1
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            // here have to put into paranthese (n & mask)
            if ((n & mask) != 0) {
                ans++;
            }

            mask <<= 1;
        }

        return ans;
    }

    /**
     * solution 2: use built-in function
     *
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }

    /**
     * solution 3: >>> for unsigned bit shift
     *
     * bit shift and check last bit == 1 until it's 0.
     *
     * @param n
     * @return
     */
    public int hammingWeight3(int n) {
        int bitCount = 0;
        while (n != 0) {
            bitCount += n & 1;
            // key: unsigned bit shift operation
            // >>: signed bit shift which keeps the left-most sigin bits
            n >>>= 1;
        }

        return bitCount;
    }


    /**
     * solution 4: Brian Kernighan's Algorithm: has least iteration by ignoring all the 0 bits
     *
     * @param n
     * @return
     */
    public int hammingWeight4(int n) {
        int bitCount = 0;
        while (n != 0) {
            bitCount++;
            n &= (n - 1);
        }

        return bitCount;
    }

}
