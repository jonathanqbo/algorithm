package leecode.bq.algorithm;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/20/21 10:30 AM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q1242WebCrawlerMultithreaded {

    class Solution {

        public List<String> crawl(String startUrl, HtmlParser htmlParser) {
            String hostname = getHostname(startUrl);

            Set<String> visited = ConcurrentHashMap.newKeySet();
            visited.add(startUrl);

            return crawl(startUrl, htmlParser, hostname, visited)
                    .collect(Collectors.toList());
        }

        private Stream<String> crawl(String startUrl, HtmlParser htmlParser, String hostname, Set<String> visited) {
            Stream<String> stream = htmlParser.getUrls(startUrl)
                    .parallelStream()
                    .filter(url -> isSameHostname(url, hostname))
                    .filter(url -> visited.add(url))
                    .flatMap(url -> crawl(url, htmlParser, hostname, visited));

            return Stream.concat(Stream.of(startUrl), stream);
        }

        private String getHostname(String url) {
            int idx = url.indexOf('/', 7);
            return (idx != -1) ? url.substring(0, idx) : url;
        }

        private boolean isSameHostname(String url, String hostname) {
            if (!url.startsWith(hostname)) {
                return false;
            }
            return url.length() == hostname.length() || url.charAt(hostname.length()) == '/';
        }

    }

    interface HtmlParser {
        public List<String> getUrls(String url) ;
    }

}
