package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/2/21 10:17 PM
 */
public class Q833FindAndReplaceInString {

    /**
     * solution: use matches array, and substring / string.equals
     *
     * Runtime: 1 ms, faster than 99.19% of Java online submissions for Find And Replace in String.
     * Memory Usage: 39.5 MB, less than 18.82% of Java online submissions for Find And Replace in String.
     *
     * @param S
     * @param indexes
     * @param sources
     * @param targets
     * @return
     */
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int n = S.length();

        // instead of using map, here just use an array
        int[] matches = new int[n];
        for (int i = 0; i < indexes.length; i++) {
            String source = sources[i];
            if (S.substring(indexes[i], indexes[i] + source.length()).equals(source)) {
                // keep its original index in indexes
                // use i + 1 to distingush with array default value 0
                matches[indexes[i]] = i + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            if (matches[i] > 0) {
                sb.append(targets[matches[i] - 1]);
                i += sources[matches[i] - 1].length();
            } else {
                sb.append(S.charAt(i++));
            }
        }

        return sb.toString();
    }


    /**
     * use Map, and use low level string operation
     *
     * @param S
     * @param indexes
     * @param sources
     * @param targets
     * @return
     */
    public String findReplaceString2(String S, int[] indexes, String[] sources, String[] targets) {
         Map<Integer, Integer> indexToOrder = new HashMap();
         for (int i = 0; i < indexes.length; i++) {
             indexToOrder.put(indexes[i], i);
         }

         int n = S.length();

         StringBuilder sb = new StringBuilder();
         for (int i = 0; i < n; i++) {
             if (!indexToOrder.containsKey(i)) {
                 sb.append(S.charAt(i));
                 continue;
             }

             int order = indexToOrder.get(i);
             String source = sources[order];
             String target = targets[order];

             boolean replace = true;
             for (int j = 0; j < source.length() && i < n; j++) {
                 if (source.charAt(j) != S.charAt(i + j)) {
                     replace = false;
                     break;
                 }
             }

             if (replace) {
                 sb.append(target);
                 i += source.length() - 1;
             } else {
                 sb.append(S.charAt(i));
             }
         }

         return sb.toString();
     }
}
