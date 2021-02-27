package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/24/21 12:06 AM
 */
public class Q843GuesstheWord {

    /**
     * solution 1: random pick one word, and filter out words lists to keep words that has same match amount, since the
     * answer must have same match.
     *
     */
    class Solution {
        public void findSecretWord(String[] wordlist, Master master) {
            for (int i = 0; i < 10; i++) {
                String guess = wordlist[new Random().nextInt(wordlist.length)];

                int matchs = master.guess(guess);
                if (matchs == 6) {
                    return;
                }

                List<String> candidates = new ArrayList<>();
                for (String word: wordlist) {
                    if (similarity(word, guess) == matchs) {
                        candidates.add(word);
                    }
                }
                wordlist = candidates.toArray(new String[0]);
            }


        }

        private int similarity(String word, String target) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == target.charAt(i)) {
                    count++;
                }
            }

            return count;
        }
    }



    interface Master {
        public int guess(String word);
    }

}
