package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        return bfs(root);
//        return dfs(root);
    }

    private List<Integer> bfs(TreeNode node) {
        List<Integer> results = new ArrayList<>();
        if (node == null) return results;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if (i == size - 1) {
                    results.add(n.val);
                }
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
        }

        return results;
    }

    private List<Integer> dfs(TreeNode node) {
        List<Integer> results = new ArrayList<>();
        if (node == null) return results;

        dfs(node, 0, results);

        return results;
    }

    private void dfs(TreeNode node, int depth, List<Integer> results) {

        if (node == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
        if (depth == results.size()) {
            results.add(node.val);
        }
        depth++;

        dfs(node.right, depth, results);
        dfs(node.left, depth, results);
    }



    public static void main(String[] args) {
        BinaryTreeRightSideView solution = new BinaryTreeRightSideView();

        // Test case
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println("Right Side View: " + solution.rightSideView(root)); // Output: [1, 3, 4]
    }
}
