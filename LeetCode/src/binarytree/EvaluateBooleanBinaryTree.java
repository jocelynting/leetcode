package binarytree;

public class EvaluateBooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    private boolean dfs(TreeNode node) {

        if (node.left == null && node.right == null) {
            return node.val == 1 ? true : false;
        }

        boolean left = dfs(node.left);
        boolean right = dfs(node.right);

        return node.val == 2 ? left || right : left && right;
    }

    public static void main(String[] args) {
        EvaluateBooleanBinaryTree solution = new EvaluateBooleanBinaryTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(solution.evaluateTree(root)); // Output: true
    }
}
