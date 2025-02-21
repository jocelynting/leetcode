package binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> cur, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        cur.add(node.val);

        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(cur));
        } else {
            dfs(node.left, targetSum - node.val, cur, result);
            dfs(node.right, targetSum - node.val, cur, result);
        }

        cur.remove(cur.size() - 1);
    }

    public static void main(String[] args) {
        PathSumII solution = new PathSumII();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        System.out.println(solution.pathSum(root, targetSum));
        // Output: [[5,4,11,2],[5,8,4,5]]

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        targetSum = 5;
        System.out.println(solution.pathSum(root, targetSum));
        // Output: []
    }
}
