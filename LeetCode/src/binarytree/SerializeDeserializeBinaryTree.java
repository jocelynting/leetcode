package binarytree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        if (root == null) return "null";
        StringBuilder sb = new StringBuilder();
        serializeTree(root, sb);
        return sb.toString();
    }

    private void serializeTree(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
        } else {
            sb.append(node.val).append(",");
            serializeTree(node.left, sb);
            serializeTree(node.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        return deserializeTree(list);
    }

    private TreeNode deserializeTree(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = deserializeTree(list);
        root.right = deserializeTree(list);
        return root;
    }


    public static void main(String[] args) {
        SerializeDeserializeBinaryTree codec = new SerializeDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = codec.serialize(root);
        System.out.println("Serialized tree: " + serialized);

        TreeNode deserialized = codec.deserialize(serialized);
        System.out.println("Deserialized tree: " + codec.serialize(deserialized));
    }
}
