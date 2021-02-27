package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/24/21 10:04 PM
 */
public class Q953VerifyinganAlienDictionary {

    /**
     * solution: check each adjacent words
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Verifying an Alien Dictionary.
     * Memory Usage: 37.9 MB, less than 57.33% of Java online submissions for Verifying an Alien Dictionary.
     *
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted(String[] words, String order) {
        // KEY: build char-idx mapping
        int[] charToIdx = new int[26];
        for (int i = 0; i < order.length(); i++) {
            charToIdx[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            // key: compare each two words
            if (compare(words[i], words[i + 1], charToIdx) > 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 1: word1 > word2,  0: word1 == word2,  -1: word1 < word2
     */
    private int compare(String word1, String word2, int[] charToIdx) {
        int n1 = word1.length();
        int n2 = word2.length();
        int minLength = Math.min(n1, n2);

        for (int i = 0; i < minLength; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (c1 == c2) {
                continue;
            }

            return charToIdx[c1 - 'a'] - charToIdx[c2 - 'a'];
        }

        return n1 - n2;
    }

}
