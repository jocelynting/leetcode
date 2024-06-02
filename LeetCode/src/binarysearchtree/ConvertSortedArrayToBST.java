package binarysearchtree;

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = build(nums, left, mid - 1);
        node.right = build(nums, mid + 1, right);
        return node;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBST solution = new ConvertSortedArrayToBST();

        int[] nums1 = {-10, -3, 0, 5, 9};
        TreeNode result1 = solution.sortedArrayToBST(nums1);
        System.out.println("Test Case 1: " + preOrderTraversal(result1)); // Output: [0, -10, -3, 5, 9]

        int[] nums2 = {1, 3};
        TreeNode result2 = solution.sortedArrayToBST(nums2);
        System.out.println("Test Case 2: " + preOrderTraversal(result2)); // Output: [1, 3]
    }

    public static String preOrderTraversal(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrderHelper(root, sb);
        return sb.toString();
    }

    private static void preOrderHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.val).append(" ");
        preOrderHelper(node.left, sb);
        preOrderHelper(node.right, sb);
    }
}
