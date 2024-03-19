package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
//        return dfs(root);
        return bfs(root);
    }

    private int bfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();

                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }

            result++;
        }

        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();

        // Test case
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Maximum Depth of Binary Tree: " + solution.maxDepth(root)); // Output: 3
    }
}
