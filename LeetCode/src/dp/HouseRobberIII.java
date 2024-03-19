package dp;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] result = robSubtree(root);
        return Math.max(result[0],result[1]);
    }

    private int[] robSubtree(TreeNode node) {
       if (node == null) {
           return new int[]{0, 0};
       }

       int[] left = robSubtree(node.left);
       int[] right = robSubtree(node.right);

       int rob = node.val + left[1] + right[1];
       int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

       return new int[]{rob, notRob};
    }

    public static void main(String[] args) {
        HouseRobberIII solution = new HouseRobberIII();

        // Test case
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println(solution.rob(root)); // Output: 7
    }

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
