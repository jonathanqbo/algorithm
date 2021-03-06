package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/6/21 12:47 AM
 */
public class Q1348TweetCountsPerFrequency {

    /**
     * solution: TreeMap with subMap
     */
    class TweetCounts {

        // map: tweetName: Map<time, amount of tweet with same time>
        private Map<String, TreeMap<Integer, Integer>> tweets;

        public TweetCounts() {
            tweets = new HashMap<>();
        }

        public void recordTweet(String tweetName, int time) {
            tweets.putIfAbsent(tweetName, new TreeMap<>());
            Map<Integer, Integer> map = tweets.get(tweetName);
            map.put(time, map.getOrDefault(time, 0) + 1);
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            if (!tweets.containsKey(tweetName)) {
                return null;
            }

            int delta = 0;
            switch (freq) {
                case "minute":
                    delta = 60;
                    break;
                case "hour":
                    delta = 60 * 60;
                    break;
                case "day":
                    delta = 24 * 60 * 60;
                    break;
                default:
                    throw new IllegalArgumentException();
            }

            Map<Integer, Integer> subTweets = tweets.get(tweetName).subMap(startTime, true, endTime, true);

            // note: calculate intervals
            int intervals = (endTime - startTime) / delta + 1;
            int[] buckets = new int[intervals];
            for (Map.Entry<Integer, Integer> kv: subTweets.entrySet()) {
                int bucketIdx = (kv.getKey() - startTime) / delta;
                buckets[bucketIdx] += kv.getValue();
            }

            List<Integer> result = new ArrayList<>(intervals);
            for (int count: buckets) {
                result.add(count);
            }
            return result;
        }

    }

}
