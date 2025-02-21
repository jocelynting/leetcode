package binarytree;

public class DirectionsFromBinaryTreeNodeToAnother {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = findLCA(root, startValue, destValue);
        StringBuilder startSB = new StringBuilder();
        StringBuilder destSB = new StringBuilder();

        findPath(LCA, startValue, startSB);
        findPath(LCA, destValue, destSB);

        StringBuilder sb = new StringBuilder();
        sb.append("U".repeat(startSB.length())).append(destSB);

        return sb.toString();
    }

    private TreeNode findLCA(TreeNode node, int value1, int value2) {
        if (node == null) {
            return null;
        }

        if (node.val == value1 || node.val == value2) {
            return node;
        }

        TreeNode left = findLCA(node.left, value1, value2);
        TreeNode right = findLCA(node.right, value1, value2);

        if (left == null && right == null) {
            return null;
        }

        if (left != null && right != null) {
            return node;
        }

        return left == null ? right : left;
    }

    private boolean findPath(TreeNode node, int value, StringBuilder path) {
        if (node == null) {
            return false;
        }

        if (node.val == value) {
            return true;
        }

        path.append("L");
        if (findPath(node.left, value, path)) {
            return true;
        }
        path.setLength(path.length() - 1);

        path.append("R");
        if (findPath(node.right, value, path)) {
            return true;
        }
        path.setLength(path.length() - 1);

        return false;
    }

    public static void main(String[] args) {
        DirectionsFromBinaryTreeNodeToAnother solution = new DirectionsFromBinaryTreeNodeToAnother();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        int startValue = 3;
        int destValue = 6;

        System.out.println(solution.getDirections(root, startValue, destValue));// Output: "UURL"
    }
}
