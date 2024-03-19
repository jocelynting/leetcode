package binarysearchtree;

import java.util.Stack;

public class ValidateBinarySearchTree {
    Long max = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            if (node.val <= max) return false;

            max = (long) node.val;

            node = node.right;

        }

        return true;
//        return dfsPreorder(root, Long.MIN_VALUE, Long.MAX_VALUE);
//        return dfsInorder(root);
    }

    private boolean dfsPreorder(TreeNode node, Long min, Long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return dfsPreorder(node.left, min, (long) node.val) && dfsPreorder(node.right, (long) node.val, max);
    }

    private boolean dfsInorder(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (!dfsInorder(node.left) || node.val <= max) {
            return false;
        }

        max = (long) node.val;

        return dfsInorder(node.right);
    }


    public static void main(String[] args) {
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();

        // Test case
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println("Is Valid BST: " + solution.isValidBST(root)); // Output: true
    }


}
