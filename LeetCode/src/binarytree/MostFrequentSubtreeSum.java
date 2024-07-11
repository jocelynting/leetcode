package binarytree;

import java.util.*;

public class MostFrequentSubtreeSum {

    private Map<Integer, Integer> map;
    private int maxCount;

    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        maxCount = 0;

        subtreeSum(root);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                result.add(entry.getKey());
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int subtreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = subtreeSum(node.left);
        int right = subtreeSum(node.right);
        int sum = left + right + node.val;

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, map.get(sum));

        return sum;
    }

    public static void main(String[] args) {
        MostFrequentSubtreeSum solution = new MostFrequentSubtreeSum();

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(-3);
        System.out.println(Arrays.toString(solution.findFrequentTreeSum(root1))); // Output: [2, -3, 4]

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(-5);
        System.out.println(Arrays.toString(solution.findFrequentTreeSum(root2))); // Output: [2]
    }
}
