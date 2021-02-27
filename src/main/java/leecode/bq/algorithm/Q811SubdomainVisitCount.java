package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/24/21 11:31 PM
 */
public class Q811SubdomainVisitCount {

    /**
     * solution 1: indexOf and substring for better performance
     *
     * Runtime: 5 ms, faster than 99.76% of Java online submissions for Subdomain Visit Count.
     * Memory Usage: 39.4 MB, less than 98.99% of Java online submissions for Subdomain Visit Count.
     *
     * @param cpdomains
     * @return
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainToCount = new HashMap<>();
        for (String cpDomain: cpdomains) {
            int idxSpace = cpDomain.indexOf(" ");
            int count = Integer.parseInt(cpDomain.substring(0, idxSpace));
            String domain = cpDomain.substring(idxSpace + 1);
            while (true) {
                domainToCount.put(domain, domainToCount.getOrDefault(domain, 0) + count);

                int dotIdx = domain.indexOf(".");
                if (dotIdx < 0) {
                    break;
                }

                domain = domain.substring(dotIdx + 1);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> kv: domainToCount.entrySet()) {
            result.add(new StringBuilder().append(kv.getValue()).append(" ").append(kv.getKey()).toString());
        }

        return result;
    }


    /**
     * solution 2: split
     *
     * runtime: 23ms
     *
     * @param cpdomains
     * @return
     */
    public List<String> subdomainVisits2(String[] cpdomains) {
         Map<String, Integer> domainToCount = new HashMap<>();
         for (String domain: cpdomains) {
             String[] countNDomain = domain.split("\\s");
             String[] domainFragments = countNDomain[1].split("\\.");

             int count = Integer.parseInt(countNDomain[0]);

             StringBuilder sb = new StringBuilder();
             for (int i = domainFragments.length - 1; i >= 0; i--) {
                 StringBuilder curSb = new StringBuilder().append(domainFragments[i]);
                 if (i != domainFragments.length - 1) {
                     curSb.append('.').append(sb);
                 }

                 String curStr = curSb.toString();
                 domainToCount.put(curStr, domainToCount.getOrDefault(curStr, 0) + count);
                 sb = curSb;
             }
         }

         List<String> result = new ArrayList<>();
         for (Map.Entry<String, Integer> kv: domainToCount.entrySet()) {
             result.add(new StringBuilder().append(kv.getValue()).append(" ").append(kv.getKey()).toString());
         }

         return result;
     }

}
