package binarytree;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }

        return dfs(root,subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean dfs(TreeNode node, TreeNode subNode) {
        if (node == null && subNode == null) {
            return true;
        }

        if (node == null || subNode == null || node.val != subNode.val) {
            return false;
        }

        return dfs(node.left,subNode.left) && dfs(node.right, subNode.right);
    }

    public static void main(String[] args) {
        SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();

        // Test cases
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println("Is t a subtree of s? " + solution.isSubtree(s, t)); // Output: true
    }
}
