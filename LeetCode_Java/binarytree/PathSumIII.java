package binarytree;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return backtracking(root, targetSum, map, 0);
    }

    private int backtracking(TreeNode node, int target, Map<Long, Integer> map, long sum) {
        if (node == null) {
            return 0;
        }

        sum += node.val;
        long targetSum = sum - target;
        int count = map.getOrDefault(targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        int result = count + backtracking(node.left, target, map, sum) + backtracking(node.right, target, map, sum);
        map.put(sum, map.get(sum) - 1);

        return result;
    }

    public static void main(String[] args) {
        PathSumIII solver = new PathSumIII();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum1 = 8;
        System.out.println(solver.pathSum(root, targetSum1)); // Expected output: 3

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(11);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(7);
        root2.left.left.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(5);
        root2.right.right.right = new TreeNode(1);

        int targetSum2 = 22;
        System.out.println(solver.pathSum(root2, targetSum2)); // Expected output: 3
    }
}
