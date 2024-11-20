package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveSubFoldersFromFilesystem {

    class TrieNode {

        public Map<String, TrieNode> children;
        public boolean isEnd;

        public TrieNode() {
            children = new HashMap<>();
        }
    }

    private TrieNode root;

    public List<String> removeSubfolders(String[] folder) {
        root = new TrieNode();

        for (String path : folder) {
            insert(path);
        }

        List<String> result = new ArrayList<>();
        for (String path : folder) {
            TrieNode node = root;
            String[] names = path.split("/");
            boolean isSub = false;

            for (int i = 0; i < names.length; i++) {
                String n = names[i];
                if (n.equals("")) continue;
                TrieNode next = node.children.get(n);
                if (next.isEnd && i != names.length - 1) {
                    isSub = true;
                    break;
                }
                node = next;
            }

            if (!isSub) {
                result.add(path);
            }
        }

        return result;
    }

    private void insert(String path) {
        TrieNode node = root;
        String[] names = path.split("/");

        for (String n : names) {
            if (n.equals("")) continue;
            if (!node.children.containsKey(n)) {
                node.children.put(n, new TrieNode());
            }
            node = node.children.get(n);
        }

        node.isEnd = true;
    }

    public static void main(String[] args) {
        RemoveSubFoldersFromFilesystem solution = new RemoveSubFoldersFromFilesystem();
        String[] folders1 = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        System.out.println(solution.removeSubfolders(folders1)); // Output: ["/a","/c/d","/c/f"]

        String[] folders2 = {"/a", "/a/b/c", "/a/b/d"};
        System.out.println(solution.removeSubfolders(folders2)); // Output: ["/a"]
    }
}
