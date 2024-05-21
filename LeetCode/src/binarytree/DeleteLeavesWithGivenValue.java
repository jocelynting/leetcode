package binarytree;

public class DeleteLeavesWithGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root, target);
    }

    private TreeNode dfs(TreeNode node, int target) {
        if (node == null) {
            return null;
        }

        node.left = dfs(node.left, target);
        node.right = dfs(node.right, target);

        if (node.left == null && node.right == null && node.val == target) {
            return null;
        }

        return node;
    }

    public static void main(String[] args) {
        DeleteLeavesWithGivenValue solution = new DeleteLeavesWithGivenValue();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        TreeNode result1 = solution.removeLeafNodes(root, 2);
        printInOrder(result1); // Output: [1, null, 3, null, 4]
    }

    private static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
}
