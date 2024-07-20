package designclass;

import java.util.*;

public class FileSystem {

    private class FileSystemNode {
        String content;
        boolean isFile;
        Map<String, FileSystemNode> children;

        public FileSystemNode() {
            content = "";
            isFile = false;
            children = new HashMap<>();
        }
    }

    FileSystemNode root;

    public FileSystem() {
        root = new FileSystemNode();
    }

    public List<String> ls(String path) {
        FileSystemNode node = traverse(path);
        List<String> result = new ArrayList<>();
        if (node.isFile) {
            int index = path.lastIndexOf('/');
            result.add(path.substring(index + 1));
        } else {
            result.addAll(node.children.keySet());
            Collections.sort(result);
        }
        return result;
    }

    public void mkdir(String path) {
        traverse(path);
    }

    public void addContentToFile(String filePath, String content) {
        FileSystemNode node = traverse(filePath);
        node.isFile = true;
        node.content += content;
    }

    public String readContentFromFile(String filePath) {
        FileSystemNode node = traverse(filePath);
        return node.content;
    }

    private FileSystemNode traverse(String path) {
        FileSystemNode cur = root;
        if (path.equals("/")) {
            return cur;
        }

        String[] paths = path.split("/");
        for (String p : paths) {
            if (p.isEmpty()) continue;
            cur.children.putIfAbsent(p, new FileSystemNode());
            cur = cur.children.get(p);
        }

        return cur;
    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        System.out.println(fileSystem.ls("/")); // []

        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        System.out.println(fileSystem.ls("/")); // ["a"]
        System.out.println(fileSystem.readContentFromFile("/a/b/c/d")); // "hello"
    }
}
