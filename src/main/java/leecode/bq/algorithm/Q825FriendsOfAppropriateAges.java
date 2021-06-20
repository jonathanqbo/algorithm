package leecode.bq.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:26 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q825FriendsOfAppropriateAges {

    /**

     solution 1: Brute force (Time Limit Exceeded)

     just check each comparation

     ---------------

     solution 2: Group same age (prefer)

     key: same age needs be special handled


     ---------------

     solution 3: Sorting and Binary Search (actually worse in timecost)

     */
    class Solution {
        public int numFriendRequests(int[] ages) {
            int res = 0;
            Arrays.sort(ages);
            for (int i = 0; i < ages.length; ++i) {
                int age = ages[i];
                int lower = firstIdx(ages, age/2+7);
                int upper = firstIdx(ages, age);
                res += Math.max(upper-lower-1, 0);
            }
            return res;
        }

        private int firstIdx(int[] ages, int target) {
            int beg = 0;
            int end = ages.length-1;
            while (beg <= end) {
                int mid = beg + (end-beg)/2;
                if (ages[mid] <= target) beg = mid + 1;
                else end = mid - 1;
            }
            return beg;
        }
    }

    class Solution2 {

        public int numFriendRequests(int[] ages) {
            Map<Integer, Integer> ageToCount = new HashMap<>();
            for (int age : ages) {
                ageToCount.put(age, ageToCount.getOrDefault(age, 0) + 1);
            }

            int result = 0;

            for (Integer ageA : ageToCount.keySet()) {
                for (Integer ageB : ageToCount.keySet()) {
                    if (canRequest(ageA, ageB)) {
                        result += ageToCount.get(ageA) * (ageToCount.get(ageB) + (ageA == ageB ? -1 : 0));
                    }
                }
            }

            return result;
        }

        private boolean canRequest(int ageA, int ageB) {
            if (ageB <= 0.5 * ageA + 7 || ageB > ageA || (ageB > 100 && ageA < 100)) {
                return false;
            }

            return true;
        }

    }



    class Solution1 {

        public int numFriendRequests(int[] ages) {
            int n = ages.length;
            int result = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (canRequest(ages[i], ages[j])) {
                        result++;
                    }
                    if (canRequest(ages[j], ages[i])) {
                        result++;
                    }
                }
            }

            return result;
        }


        private boolean canRequest(int ageA, int ageB) {
            if (ageB <= 0.5 * ageA + 7 || ageB > ageA || (ageB > 100 && ageA < 100)) {
                return false;
            }

            return true;
        }
    }

}
