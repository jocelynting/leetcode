package binarytree;

public class LowestCommonAncestorBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q) {
            return node;
        }

        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right,p ,q);

        if (left != null && right != null) {
            return node;
        }

        if (left == null && right == null) {
            return null;
        }

        return left == null ? right : left;
    }

    public static void main(String[] args) {
        // Test case
        LowestCommonAncestorBinaryTree solution = new LowestCommonAncestorBinaryTree();

        // Construct the tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left; // 5
        TreeNode q = root.left.right.right; // 4
        TreeNode result = solution.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of nodes " + p.val + " and " + q.val + " is: " + result.val);
        // Output: 5
    }
}
