package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/21/21 5:44 PM
 */
public class Q642DesignSearchAutocompleteSystem {

    /**
     * solution: Trie
     *
     * Runtime: 98 ms, faster than 98.65% of Java online submissions for Design Search Autocomplete System.
     * Memory Usage: 47.9 MB, less than 90.89% of Java online submissions for Design Search Autocomplete System.
     *
     */
    class AutocompleteSystem {
        TrieNode root = new TrieNode();
        StringBuilder curStr = new StringBuilder();

        public AutocompleteSystem(String[] sentences, int[] times) {
            for (int i = 0; i < sentences.length; i++) {
                insertTrie(sentences[i], times[i]);
            }
        }

        public List<String> input(char c) {
            if (c == '#') {
                insertTrie(curStr.toString(), 1);
                curStr = new StringBuilder();

                return Collections.emptyList();
            }

            curStr.append(c);

            return search(curStr.toString());
        }

        void insertTrie(String str, int timesIncrease) {
            TrieNode node = root;
            List<TrieNode> path = new ArrayList<>();
            path.add(node);
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                int idx = charToIdx(c);
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }

                node = node.children[idx];
                path.add(node);
            }

            node.sentence = str;
            node.times += timesIncrease;

            // update top3 in each node in path
            for (TrieNode nodeInPath: path) {
                List<TrieNode> tops = nodeInPath.tops;
                if (!tops.contains(node)) {
                    tops.add(node);
                }

                Collections.sort(tops, (n1, n2) -> n1.times == n2.times ? n1.sentence.compareTo(n2.sentence) :  n2.times - n1.times);

                if (tops.size() > 3) {
                    tops.remove(tops.size() - 1);
                }
            }
        }

        List<String> search(String prefix) {
            List<TrieNode> nodes = new ArrayList<>();

            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int idx = charToIdx(c);
                if (node.children[idx] == null) {
                    return Collections.emptyList();
                }

                node = node.children[idx];
            }

            List<String> results = new ArrayList<>();
            for (TrieNode resultNode: node.tops) {
                results.add(resultNode.sentence);
            }

            return results;
        }

        int charToIdx(char c) {
            if (c == ' ') {
                return 26;
            }

            return c - 'a';
        }


        class TrieNode {
            TrieNode[] children = new TrieNode[27];
            String sentence;
            int times = 0;
            List<TrieNode> tops = new ArrayList<>();
        }

    }

}
