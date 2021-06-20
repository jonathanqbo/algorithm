package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 9:27 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q269AlienDictionary {

    /**

     solution: directed graph + topological sort by inbound degree

     graph representation: Adjacent list, Map<Character, List<Character>>
     int[26] inboundDegress (only contains lowercase letter)


     1. build graph, and inboundDegrees:
     for each word[i] and word[i+1]
     check if two words not sort properly: word[i+1] is prefix of word[i], and word[i+1].length < word[i]
     find the first different char c1, c2: add to graph as one edge: graph.put(c1, list.add(c2)) => c1 -> c2
     2. BFS from nodes that inbounds degree == 0, and keep into StringBuilder
     reduce neighbors inDegree
     add to queue if neighbor indegree == 0
     3. if StringBuilder.length < total chars, no result, otherwise return StringBuilder.tostring


     time complexity: O(c), c = m * n, M is words amount, N is each word length
     space complexity: O(1), since the graph is not more than 26 nodes and their edges.

     */


    class Solution {

        public String alienOrder(String[] words) {
            Map<Character, Set<Character>> graph = new HashMap<>();
            Map<Character, Integer> inDegree = new HashMap<>();

            for (int i = 0; i < words.length; i++) {
                String word1 = words[i];
                for (int j = 0; j < word1.length(); j++) {
                    char c = word1.charAt(j);
                    inDegree.putIfAbsent(c, 0);
                }

                if (i == words.length - 1) {
                    break;
                }

                String word2 = words[i + 1];

                int p = 0;
                while (p < word1.length() && p < word2.length() && word1.charAt(p) == word2.charAt(p)) {
                    p++;
                }

                if (p < word1.length() && p < word2.length()) {
                    char c1 = word1.charAt(p);
                    char c2 = word2.charAt(p);
                    boolean notExisted = graph.computeIfAbsent(c1, k -> new HashSet<>()).add(c2);
                    if (notExisted) {
                        inDegree.put(c2, inDegree.getOrDefault(c2, 0) + 1);
                    }

                    continue;
                }

                // wrong case
                if (word1.length()  > word2.length()) {
                    return "";
                }
            }

            Queue<Character> queue = new LinkedList<>();
            inDegree.forEach((k, v) -> {
                if (v == 0) {
                    queue.offer(k);
                }
            });

            StringBuilder result = new StringBuilder();
            while (!queue.isEmpty()) {
                char c = queue.poll();
                result.append(c);

                if (graph.containsKey(c)) {
                    for (char neighbor : graph.get(c)) {
                        inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                        if (inDegree.get(neighbor) == 0) {
                            queue.offer(neighbor);
                        }
                    }
                }

            }

            if (result.length() < inDegree.size()) {
                return "";
            }

            return result.toString();
        }

    }

}
