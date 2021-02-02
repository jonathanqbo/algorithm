package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/20/21 10:18 PM
 */
public class Q190ReverseBits {

    /**
     * solution1 :
     *
     * Runtime: 1 ms, faster than 98.79% of Java online submissions for Reverse Bits.
     * Memory Usage: 38.3 MB, less than 98.16% of Java online submissions for Reverse Bits.
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int result = 0;

        int power = 31;
        while (n != 0) {
            // java doesn't have <<<, because <<< is same as <<
            // reverse bit
            result = result | ((n & 1) << power);
            power--;
            // >>> is to do unsign bit shift
            n >>>= 1;
        }

        return result;
    }

    /**
     * solution 2: more generic solution
     *
     * Runtime: 1 ms, faster than 98.79% of Java online submissions for Reverse Bits.
     * Memory Usage: 38.4 MB, less than 88.82% of Java online submissions for Reverse Bits.
     *
     * @param n
     * @return
     */
    public int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (isBit1(n, i)) {
                result = setBit1(result, 31 - i);
            }
        }
        return result;
    }

    public int setBit1(int num, int i) {
        return num | (1 << i);
    }

    public boolean isBit1(int num, int i) {
        return (num & (1 << i)) != 0;
    }

}
