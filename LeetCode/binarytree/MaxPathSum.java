package binarytree;

public class MaxPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode node){
        if (node == null){
            return 0;
        }

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0,dfs(node.right));

        max = Math.max(max, left + right + node.val);

        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        MaxPathSum solution = new MaxPathSum();

        // Example usage:
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(7);

        System.out.println(solution.maxPathSum(root)); // Output: 42
    }
}
