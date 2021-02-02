package leecode.bq.algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/20/21 11:20 PM
 */
public class Q929UniqueEmailAddresses {

    /**
     * Runtime: 5 ms, faster than 98.53% of Java online submissions for Unique Email Addresses.
     * Memory Usage: 39.3 MB, less than 73.74% of Java online submissions for Unique Email Addresses.
     *
     * @param emails
     * @return
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet();

        for (String email : emails) {
            int atIndex = email.indexOf("@");
            // note: substring() all lowercase
            String localName = email.substring(0, atIndex);
            String domainName = email.substring(atIndex);

            // + sign
            int plusIndex = localName.indexOf("+");
            if (plusIndex > 0) {
                localName = localName.substring(0, plusIndex);
            }

            // . sign
            localName = localName.replace(".", "");

            emailSet.add(localName + domainName);
        }

        return emailSet.size();
    }

    /**
     * solution: regex partially
     * <p>
     * Runtime: 23 ms, faster than 33.99% of Java online submissions for Unique Email Addresses.
     * Memory Usage: 40.2 MB, less than 40.45% of Java online submissions for Unique Email Addresses.
     *
     * @param emails
     * @return
     */
    public int numUniqueEmails2(String[] emails) {
        Set<String> emailSet = new HashSet();

        Pattern p = Pattern.compile("(\\.|(\\+.*))");
        for (String email : emails) {
            int atsignIndex = email.indexOf("@");
            String domain = email.substring(atsignIndex);
            String local = email.substring(0, atsignIndex);

            String canonicalEmail = p.matcher(local).replaceAll("");

            // String canonicalEmail = local.replaceAll("(\\.|(\\+.*))", "");
            emailSet.add(canonicalEmail + domain);
        }

        return emailSet.size();
    }

}
