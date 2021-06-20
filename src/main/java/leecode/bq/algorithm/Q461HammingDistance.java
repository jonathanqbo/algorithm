package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:06 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q461HammingDistance {

    class Solution {

        public int hammingDistance(int x, int y) {
            int xor = x ^ y;
            int bitCount = 0;
            while (xor != 0) {
                bitCount++;
                xor &= (xor - 1);
            }

            return bitCount;
        }


//     public int hammingDistance(int x, int y) {
//         int xor = x ^ y;
//         int bitCount = 0;
//         while (xor != 0) {
//             bitCount += xor & 1;
//             xor >>= 1;
//         }

//         return bitCount;
//     }

        // public int hammingDistance(int x, int y) {
        //     return Integer.bitCount(x ^ y);
        // }
    }

}
