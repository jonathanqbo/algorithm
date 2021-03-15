package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/11/21 11:18 AM
 */
public class Q1472DesignBrowserHistory {

    /**
     * solution: ArrayList with curIndex
     *
     * Runtime: 45 ms, faster than 91.83% of Java online submissions for Design Browser History.
     * Memory Usage: 48.1 MB, less than 24.36% of Java online submissions for Design Browser History.
     *
     */
    class BrowserHistory {

        private List<String> history = new ArrayList<>();
        private int cur = -1;

        public BrowserHistory(String homepage) {
            history.add(homepage);
            cur = 0;
        }

        public void visit(String url) {
            for (int i = history.size() - 1; i > cur; i--) {
                history.remove(i);
            }

            history.add(url);
            cur++;
        }

        public String back(int steps) {
            cur = Math.max(0, cur - steps);
            return history.get(cur);
        }

        public String forward(int steps) {
            cur = Math.min(history.size() - 1, cur + steps);
            return history.get(cur);
        }
    }


    /**
     * solution 2: a bit difference than solution 1: instead of removing items, keep actual size.
     *
     * Runtime: 43 ms, faster than 99.67% of Java online submissions for Design Browser History.
     * Memory Usage: 47.6 MB, less than 43.26% of Java online submissions for Design Browser History.
     *
     * bit better time cost, but potential of memory leakage
     *
     */
    class BrowserHistory2 {

        private List<String> history = new ArrayList<>();
        private int cur = -1;
        private int size = 0;

        public BrowserHistory2(String homepage) {
            history.add(homepage);
            cur = 0;
            size = 1;
        }

        public void visit(String url) {
            // NOTE: main difference
            if (cur + 1 < history.size()) {
                history.set(cur + 1, url);
            } else {
                history.add(url);
            }

            cur++;
            size = cur + 1;
        }

        public String back(int steps) {
            cur = Math.max(0, cur - steps);
            return history.get(cur);
        }

        public String forward(int steps) {
            cur = Math.min(size - 1, cur + steps);
            return history.get(cur);
        }
    }

}
