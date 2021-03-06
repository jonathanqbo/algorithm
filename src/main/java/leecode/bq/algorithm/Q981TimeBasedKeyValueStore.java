package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/28/21 5:31 PM
 */
public class Q981TimeBasedKeyValueStore {

    /**
     * solution 1: HashMap + TreeMap
     *
     * Runtime: 140 ms, faster than 37.37% of Java online submissions for Time Based Key-Value Store.
     * Memory Usage: 115.4 MB, less than 43.24% of Java online submissions for Time Based Key-Value Store.
     *
     */
    class TimeMap {
        Map<String, TreeMap<Integer, String>> map;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new TreeMap<>());
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }

            // TreeMap: if no such key, return null
            TreeMap<Integer, String> tree = map.get(key);
            Integer treeMapKey = tree.floorKey(timestamp);
            return treeMapKey == null ? "" : tree.get(treeMapKey);
        }
    }

    /**
     * solution 2: HashMap + Binary Search + List
     *
     * Runtime: 125 ms, faster than 79.08% of Java online submissions for Time Based Key-Value Store.
     * Memory
     *
     */
    class TimeMap2 {
        Map<String, List<TimeValue>> map;


        /** Initialize your data structure here. */
        public TimeMap2() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(new TimeValue(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }

            List<TimeValue> list = map.get(key);
            int idx = Collections.binarySearch(list, new TimeValue("", timestamp), (d1, d2) -> {
                return Integer.compare(d1.timestamp, d2.timestamp);
            });

            // found
            if (idx >= 0) {
                return list.get(idx).val;
            }
            // not found: insert position: - (idx + 1)
            // if insert into the head, which means no such timestamp
            if (idx == -1) {
                return "";
            }
            return list.get(-idx - 1 - 1).val;
        }

        class TimeValue {
            String val;
            int timestamp;

            TimeValue(String val, int timestamp) {
                this.val = val;
                this.timestamp = timestamp;
            }
        }
    }


    /**
     * solution 3: same with solution2 but with customized BinarySearch
     */
    class TimeMap3 {
        Map<String, List<TimeValue>> map;


        /** Initialize your data structure here. */
        public TimeMap3() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(new TimeValue(value, timestamp));
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }

            List<TimeValue> list = map.get(key);
            return binarySearch(list, timestamp);
        }

        private String binarySearch(List<TimeValue> datas, int value) {
            int left = 0, right = datas.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                TimeValue data = datas.get(mid);
                if (data.timestamp == value) {
                    return data.val;
                }
                if (data.timestamp < value) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return right < 0 ? "" : datas.get(right).val;
        }

        class TimeValue {
            String val;
            int timestamp;

            TimeValue(String val, int timestamp) {
                this.val = val;
                this.timestamp = timestamp;
            }
        }
    }

}
