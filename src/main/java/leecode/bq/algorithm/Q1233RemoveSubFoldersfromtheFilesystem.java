package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/20/21 10:29 AM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q1233RemoveSubFoldersfromtheFilesystem {

    /**

     solution 1: sort by path name + String.startsWith by checking each with former

     ---------

     solution 2: Folder Trie

     */

    class Solution {

        public List<String> removeSubfolders(String[] folder) {
            Arrays.sort(folder);

            LinkedList<String> result = new LinkedList<>();
            for (String path : folder) {
                if (result.isEmpty() || !path.startsWith(result.peekLast() + "/")) {
                    result.add(path);
                }
            }

            return result;
        }
    }

    class Solution1 {

        public List<String> removeSubfolders(String[] folder) {
            Folder root = new Folder();

            // build Folder Trie
            for (String path : folder) {
                String[] folders = path.split("/");
                Folder cur = root;
                for (String subFolder : folders) {
                    if (subFolder.isEmpty()) {
                        continue;
                    }
                    if (cur.child.containsKey(subFolder) && cur.isEnd) {
                        break;
                    }

                    cur.child.putIfAbsent(subFolder, new Folder());
                    cur = cur.child.get(subFolder);
                }

                cur.isEnd = true;
            }

            root.isEnd = false;

            // dfs
            List<String> result = new ArrayList<>();
            // List<String> onePath = new ArrayList<>();
            StringBuilder onePath = new StringBuilder();
            dfs(root, onePath, result);

            return result;
        }

        private void dfs(Folder node, StringBuilder path, List<String> result) {
            if (node.isEnd) {
                result.add(path.toString());
                return;
            }

            node.child.forEach((k, v) -> {
                path.append('/').append(k);
                dfs(v, path, result);
                path.delete(path.length() - k.length() - 1, path.length());
            });
        }
    }

    class Folder {
        Map<String, Folder> child = new HashMap<>();
        boolean isEnd;
    }

}
