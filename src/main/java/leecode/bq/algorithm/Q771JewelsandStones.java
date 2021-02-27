package leecode.bq.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/22/21 11:32 PM
 */
public class Q771JewelsandStones {

    /**
     * solution: HashSet
     *
     * Runtime: 1 ms, faster than 72.94% of Java online submissions for Jewels and Stones.
     * Memory Usage: 37.8 MB, less than 25.91% of Java online submissions for Jewels and Stones.
     *
     * @param jewels
     * @param stones
     * @return
     */
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> types = new HashSet<>();
        for (char c: jewels.toCharArray()) {
            types.add(c);
        }

        int count = 0;
        for (char type: stones.toCharArray()) {
            if (types.contains(type)) {
                count++;
            }
        }

        return count;
    }

    /**
     *
     * @param jewels
     * @param stones
     * @return
     */
     public int numJewelsInStones2(String jewels, String stones) {
         Set<Character> set = new HashSet<>();
         for (int i = 0; i < jewels.length(); i++) {
             set.add(jewels.charAt(i));
         }

         int count = 0;
         for (int i = 0; i < stones.length(); i++) {
             if (set.contains(stones.charAt(i))) {
                 count++;
             }
         }

         return count;
     }

}
