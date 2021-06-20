package leecode.bq.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 3/26/21 10:48 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q588DesignInMemoryFileSystem {

    /**
     * solution 1: treat file/folder all as file
     *
     * Runtime: 44 ms, faster than 23.46% of Java online submissions for Design In-Memory File System.
     * Memory Usage: 39.9 MB, less than 76.05% of Java online submissions for Design In-Memory File System.
     */
    class FileSystem {

        File root;

        public FileSystem() {
            root = new File();
        }

        public List<String> ls(String path) {
            String[] paths = path.split("/");
            File file = root;
            for (int i = 1; i < paths.length; i++) {
                file = file.files.get(paths[i]);
            }

            if (file.isFile) {
                return Arrays.asList(paths[paths.length - 1]);
            }

            return file.files.keySet().stream()
                    .sorted().collect(Collectors.toList());
        }

        public void mkdir(String path) {
            String[] paths = path.split("/");
            File file = root;
            for (int i = 1; i < paths.length; i++) {
                file.files.putIfAbsent(paths[i], new File());
                file = file.files.get(paths[i]);
            }
        }

        public void addContentToFile(String filePath, String content) {
            String[] paths = filePath.split("/");
            File file = root;
            // if path not existed, create it
            for (int i = 1; i < paths.length - 1; i++) {
                file.files.putIfAbsent(paths[i], new File());
                file = file.files.get(paths[i]);
            }
            // if file not existed, create it
            if (!file.files.containsKey(paths[paths.length - 1])) {
                file.files.put(paths[paths.length - 1], new File(content));
            } else {
                file.files.get(paths[paths.length - 1]).append(content);
            }

            file.append(content);
        }

        public String readContentFromFile(String filePath) {
            String[] paths = filePath.split("/");
            File file = root;
            // if path not existed, create it
            for (int i = 1; i < paths.length; i++) {
                file = file.files.get(paths[i]);
            }

            return file.read();
        }

        class File {
            boolean isFile = false;
            StringBuilder content = new StringBuilder();
            Map<String, File> files = new HashMap<>();

            public File() {
            }

            public File(String content) {
                this.isFile = true;
                this.content.append(content);
            }

            public void append(String content) {
                if (!this.isFile) {
                    throw new UnsupportedOperationException();
                }

                this.content.append(content);
            }

            public String read() {
                if (!this.isFile) {
                    throw new UnsupportedOperationException();
                }

                return this.content.toString();
            }
        }
    }

}
