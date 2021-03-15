package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/15/21 12:15 AM
 */
public class Q721AccountsMerge {

    /**
     * solution: DFS
     *
     *
     */
    class Solution {
        // solution 2: DFS
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            // KEY: build graph: first email in account connected others emails as edge in bidirection
            Map<String, List<String>> emailToNeighbors = new HashMap<>();
            Map<String, String> emailToName = new HashMap<>();

            for (List<String> account: accounts) {
                // first email
                String firstEmail = account.get(1);
                emailToNeighbors.putIfAbsent(firstEmail, new LinkedList<>());
                emailToName.put(firstEmail, account.get(0));
                // other emails
                for (int i = 2; i < account.size(); i++) {
                    String email = account.get(i);

                    emailToNeighbors.putIfAbsent(email, new LinkedList<>());
                    emailToNeighbors.get(email).add(firstEmail);
                    emailToNeighbors.get(firstEmail).add(email);
                    emailToName.put(email, account.get(0));
                }
            }

            // DFS to get all connected nodes from one email
            List<List<String>> result = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            for (String email: emailToNeighbors.keySet()) {
                if (visited.contains(email)) {
                    continue;
                }

                List<String> group = new LinkedList<>();

                Deque<String> stack = new LinkedList<>();
                visited.add(email);
                stack.push(email);
                while (!stack.isEmpty()) {
                    String anEmail = stack.pop();
                    group.add(anEmail);

                    for (String otherEmail: emailToNeighbors.get(anEmail)) {
                        if (visited.contains(otherEmail)) {
                            continue;
                        }

                        visited.add(otherEmail);
                        stack.push(otherEmail);
                    }
                }

                Collections.sort(group);
                group.add(0, emailToName.get(email));

                result.add(group);
            }

            return result;

        }
    }

    /**
     * solution: BFS
     */
    class Solution2 {
        // solution 1: BFS
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            // KEY: build graph: first email in account connected others emails as edge in bidirection
            Map<String, List<String>> emailToNeighbors = new HashMap<>();
            Map<String, String> emailToName = new HashMap<>();

            for (List<String> account: accounts) {
                // first email
                String firstEmail = account.get(1);
                emailToNeighbors.putIfAbsent(firstEmail, new LinkedList<>());
                emailToName.put(firstEmail, account.get(0));
                // other emails
                for (int i = 2; i < account.size(); i++) {
                    String email = account.get(i);

                    emailToNeighbors.putIfAbsent(email, new LinkedList<>());
                    emailToNeighbors.get(email).add(firstEmail);
                    emailToNeighbors.get(firstEmail).add(email);
                    emailToName.put(email, account.get(0));
                }
            }

            // BFS to get all connected nodes from one email
            List<List<String>> result = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            for (String email: emailToNeighbors.keySet()) {
                if (visited.contains(email)) {
                    continue;
                }

                Queue<String> queue = new LinkedList<>();
                List<String> group = new LinkedList<>();

                queue.offer(email);
                visited.add(email);
                while (!queue.isEmpty()) {
                    String aEmail = queue.poll();
                    group.add(aEmail);

                    for (String otherEmail: emailToNeighbors.get(aEmail)) {
                        if (!visited.contains(otherEmail)) {
                            // KEY: set visited first
                            visited.add(otherEmail);
                            queue.offer(otherEmail);
                        }
                    }
                }

                Collections.sort(group);
                group.add(0, emailToName.get(email));

                result.add(group);
            }

            return result;
        }
    }

}
