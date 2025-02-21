package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepth {
    public int minDepth(TreeNode root) {
//        return dfs(root);
        return bfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (node.left == null) {
            return 1 + right;
        }

        if (node.right == null) {
            return 1 + left;
        }

        return Math.min(left, right) + 1;
    }

    private int bfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if (n.left == null && n.right == null) {
                    return depth;
                }

                if (n.left != null) {
                    queue.offer(n.left);
                }

                if (n.right != null) {
                    queue.offer(n.right);
                }
            }

            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        MinimumDepth solution = new MinimumDepth();

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println(solution.minDepth(root1)); // Output: 2

        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);
        root2.right.right.right.right = new TreeNode(6);
        System.out.println(solution.minDepth(root2)); // Output: 5

        TreeNode root3 = null;
        System.out.println(solution.minDepth(root3)); // Output: 0
    }
}
