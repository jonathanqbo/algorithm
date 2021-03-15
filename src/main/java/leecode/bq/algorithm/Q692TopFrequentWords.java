package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/7/21 6:04 PM
 */
public class Q692TopFrequentWords {

    /**
     * solution1: HashMap + PriorityQueue
     *
     * Runtime: 5 ms, faster than 87.08% of Java online submissions for Top K Frequent Words.
     * Memory Usage: 39.1 MB, less than 79.72% of Java online submissions for Top K Frequent Words.
     *
     */
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> wordCount = new HashMap<>();
            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }

            Queue<String> topKWords = new PriorityQueue<>( (word1, word2) -> {
                // NOTE: reverse order in queue. => word2.compareTo(word1)
                return wordCount.get(word1) == wordCount.get(word2) ?
                        word2.compareTo(word1) : wordCount.get(word1) - wordCount.get(word2);
            });

            for (String word : wordCount.keySet()) {
                topKWords.offer(word);
                if (topKWords.size() > k) {
                    topKWords.poll();
                }
            }

            List<String> result = new LinkedList<>();
            while (!topKWords.isEmpty()) {
                // low -> high when poll from queue
                // final result is high -> low, so insert into 0
                result.add(0, topKWords.poll());
            }
            // without insert 0, we need to do reverse.
            // Collections.reverse(result);

            return result;
        }
    }

}
