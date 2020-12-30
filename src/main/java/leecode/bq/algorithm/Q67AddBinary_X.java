package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Binary.
 * Memory Usage: 39 MB, less than 40.95% of Java online submissions for Add Binary.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/24/20 9:37 PM
 */
public class Q67AddBinary_X {

    public String addBinary(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        int[] result = new int[Math.max(lengthA, lengthB)];
        int lengthC = result.length;

        int carryOver = 0;
        for (int i = lengthA - 1, j = lengthB - 1, k = lengthC -1 ; k >= 0; k--, i--, j--) {
            char c1 = i < 0 ? '0' : a.charAt(i);
            char c2 = j < 0 ? '0' : b.charAt(j);

            // this is key
            int sum = carryOver + (c1 - '0') + (c2 - '0');
            result[k] = sum % 2;
            carryOver = sum / 2;
        }

        // StringBuilder makes big difference than String.valueOf()
        StringBuilder sb = new StringBuilder();
        if (carryOver == 1)
            sb.append("1");
        for (int i = 0; i < lengthC; i++)
            sb.append(result[i]);

        return sb.toString();
    }
}
