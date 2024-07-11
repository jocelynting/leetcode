package binarytree;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }

        return root;
    }

    public static void main(String[] args) {
        BinaryTreePruning solution = new BinaryTreePruning();

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(0);
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(1);
        TreeNode pruned1 = solution.pruneTree(root1);
        printTree(pruned1); // Output: 1 null 0 null 1
        System.out.println("\n");

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(0);
        root2.left.right = new TreeNode(0);
        root2.right.left = new TreeNode(0);
        root2.right.right = new TreeNode(1);
        TreeNode pruned2 = solution.pruneTree(root2);
        printTree(pruned2); // Output: 1 null 1 null 1
        System.out.println("\n");
        
        TreeNode root3 = new TreeNode(0);
        root3.left = new TreeNode(0);
        root3.right = new TreeNode(0);
        TreeNode pruned3 = solution.pruneTree(root3);
        printTree(pruned3); // Output: null
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
