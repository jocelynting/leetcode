package binarytree;

public class CountGoodNodesBinaryTree {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxValue) {
        if (node == null) {
            return 0;
        }

        int count = node.val >= maxValue ? 1 : 0;
        maxValue = Math.max(maxValue, node.val);

        count += dfs(node.left, maxValue);
        count += dfs(node.right, maxValue);

        return count;
    }

    public static void main(String[] args) {
        CountGoodNodesBinaryTree solution = new CountGoodNodesBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(solution.goodNodes(root)); // Output: 4

        root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        System.out.println(solution.goodNodes(root)); // Output: 3

        root = new TreeNode(1);
        System.out.println(solution.goodNodes(root)); // Output: 1
    }
}
