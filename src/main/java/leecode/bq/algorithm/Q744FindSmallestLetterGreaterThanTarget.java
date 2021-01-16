package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/5/21 11:53 AM
 */
public class Q744FindSmallestLetterGreaterThanTarget {

    /**
     * solution: binary search
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Smallest Letter Greater Than Target.
     * Memory Usage: 39.3 MB, less than 62.33% of Java online submissions for Find Smallest Letter Greater Than Target.
     *
     * @param letters
     * @param target
     * @return
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }


        if (left == letters.length)
            left = 0;

        return letters[left];
    }

//     public char nextGreatestLetter(char[] letters, char target) {
//         int left = 0, right = letters.length - 1;
//         while (left < right) {
//             int mid = left + (right - left) / 2;
//             if (letters[mid] <= target) {
//                 left = mid + 1;
//             } else {
//                 right = mid;
//             }
//         }

//         if (letters[left] <= target)
//             left = left + 1;

//         if (left == letters.length)
//             left = 0;

//         return letters[left];
//     }

}
