package binarytree;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);
        int gap = Math.abs(left - right);

        if (gap > 1 || left == -1 || right == -1) return -1;

        return Math.max(left,right) + 1;
    }


    public static void main(String[] args) {
        BalancedBinaryTree solution = new BalancedBinaryTree();

        // Test case
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Is the Binary Tree Balanced? " + solution.isBalanced(root)); // Output: true
    }
}
