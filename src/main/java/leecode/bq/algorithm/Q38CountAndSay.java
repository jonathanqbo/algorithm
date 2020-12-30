package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/23/20 8:35 PM
 */
public class Q38CountAndSay {

    public String countAndSay(int n) {
        if (n == 1)
            return "1";

        String result = "1";
        for (int i = 1; i < n; i++)
            result = countAndSayNext(result);

        return result;
    }

    private String countAndSayNext(String formerResult) {
        char[] chars = formerResult.toCharArray();

        int count = 1;
        char lastChar = chars[0];
        // StringBuilder makes huge difference!
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != lastChar) {
                result.append(count).append(lastChar);
                lastChar = chars[i];
                count = 1;
            } else {
                count++;
            }
        }
        result.append(count).append(lastChar);

        return result.toString();
    }

}
