package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/23/20 9:45 PM
 */
public class Q28ImplementStrStr_X {

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;

        int lengthHaystack = haystack.length();
        int lengthNeedle = needle.length();
        if (lengthHaystack < lengthNeedle)
            return -1;

        int loops = lengthHaystack - lengthNeedle + 1;
        for (int i = 0; i < loops; i++) {
            int j = 0;
            while (j < lengthNeedle && needle.charAt(j) == haystack.charAt(i + j)) {
                j++;
            }

            if (j == lengthNeedle)
                return i;
        }

        return -1;
    }

}
