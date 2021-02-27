package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/21/21 11:23 PM
 */
public class Q299BullsandCows {

    /**
     * solution: HashMap<char, count>
     *
     * Runtime: 3 ms, faster than 93.55% of Java online submissions for Bulls and Cows.
     * Memory Usage: 38 MB, less than 93.51% of Java online submissions for Bulls and Cows.
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint(String secret, String guess) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char c = secret.charAt(i);
            int count = charToCount.getOrDefault(c, 0);
            charToCount.put(c, count + 1);
        }

        int cow = 0, bull = 0;
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                bull++;

                // at this moment, count could already == 0
                if (charToCount.get(c2) <= 0) {
                    cow--;
                } else {
                    charToCount.put(c2, charToCount.get(c2) - 1);
                }
                continue;
            }

            if (!charToCount.containsKey(c2) || charToCount.get(c2) == 0) {
                continue;
            }

            int count = charToCount.get(c2);
            cow++;
            charToCount.put(c2, count - 1);
        }

        // return String.format("%dA%dB", bull, cow);
        return new StringBuilder().append(bull).append("A").append(cow).append("B").toString();
    }

}
