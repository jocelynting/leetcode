package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
//        return dfs(root);
        return bfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode left = dfs(node.left);
        TreeNode right = dfs(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    private TreeNode bfs(TreeNode node) {
        if (node == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            TreeNode n = queue.poll();

            TreeNode temp = n.left;
            n.left = n.right;
            n.right = temp;

            if (n.left != null) {
                queue.offer(n.left);
            }

            if (n.right != null) {
                queue.offer(n.right);
            }

        }

        return node;
    }

    public static void main(String[] args) {
        InvertBinaryTree solution = new InvertBinaryTree();

        // Test case
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println("Original Binary Tree:");
        printBinaryTree(root);
        System.out.println();

        TreeNode invertedRoot = solution.invertTree(root);

        System.out.println("Inverted Binary Tree:");
        printBinaryTree(invertedRoot);
        System.out.println();
    }

    private static void printBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

}
