package binarytree;

public class CountUnivalueSubtrees {
    private int count;

    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        dfs(root);
        return count;
    }

    public boolean dfs(TreeNode node) {
        if (node == null) {
            return true;
        }

        boolean left = dfs(node.left);
        boolean right = dfs(node.right);

        if (left && right) {
            if (node.left != null && node.left.val != node.val) {
                return false;
            }
            if (node.right != null && node.right.val != node.val) {
                return false;
            }
            count++;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        CountUnivalueSubtrees solution = new CountUnivalueSubtrees();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(solution.countUnivalSubtrees(root)); // Output: 4
    }
}
