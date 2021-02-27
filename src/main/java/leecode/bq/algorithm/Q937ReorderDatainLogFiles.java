package leecode.bq.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/26/21 11:48 PM
 */
public class Q937ReorderDatainLogFiles {

    static final int LETTER_LOG = 0;
    static final int DIGIT_LOG = 1;

    /**
     * Runtime: 3 ms, faster than 87.80% of Java online submissions for Reorder Data in Log Files.
     * Memory Usage: 39.4 MB, less than 63.46% of Java online submissions for Reorder Data in Log Files.
     *
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {
//        Comparator<String> comp = new Comparator<>() {
//            @Override
//            public int compare(String log1, String log2) {
//                return -1;
//            }
//        };
        Comparator<String> logComp = (log1, log2) -> {
            int i1 = log1.indexOf(" ");
            String id1 = log1.substring(0, i1);
            String content1 = log1.substring(i1 + 1);
            int type1 = Character.isDigit(content1.charAt(0)) ? DIGIT_LOG : LETTER_LOG;

            int i2 = log2.indexOf(" ");
            String id2 = log2.substring(0, i2);
            String content2 = log2.substring(i2 + 1);
            int type2 = Character.isDigit(content2.charAt(0)) ? DIGIT_LOG : LETTER_LOG;

            if (type1 != type2) {
                return type1 - type2;
            }

            if (type1 == LETTER_LOG) {
                int contentCompResult = content1.compareTo(content2);
                return contentCompResult == 0 ? id1.compareTo(id2) : contentCompResult;
            }

            // KEY: keep original order for DIGIT_LOG
            return 0;
        };

        Arrays.sort(logs, logComp);
        return logs;
    }

}
