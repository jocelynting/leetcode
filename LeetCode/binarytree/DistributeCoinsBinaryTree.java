package binarytree;

public class DistributeCoinsBinaryTree {

    private int move;
    public int distributeCoins(TreeNode root) {
        move = 0;
        dfs(root);
        return move;
    }

    private int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftCoins = dfs(node.left);
        int rightCoins = dfs(node.right);

        move += Math.abs(leftCoins) + Math.abs(rightCoins);

        return node.val - 1 + leftCoins + rightCoins;
    }

    public static void main(String[] args) {
        DistributeCoinsBinaryTree solution = new DistributeCoinsBinaryTree();

        // Test case 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(0);
        root1.right = new TreeNode(0);
        System.out.println(solution.distributeCoins(root1)); // Output: 2

        // Test case 2
        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(0);
        System.out.println(solution.distributeCoins(root2)); // Output: 3

        // Test case 3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(0);
        root3.right = new TreeNode(2);
        System.out.println(solution.distributeCoins(root3)); // Output: 2

        // Test case 4
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(0);
        root4.left.right = new TreeNode(3);
        System.out.println(solution.distributeCoins(root4)); // Output: 4
    }

}
