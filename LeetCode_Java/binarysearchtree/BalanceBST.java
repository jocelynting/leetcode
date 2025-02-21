package binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        return buildTree(inorder, 0, inorder.size() - 1);
    }

    private void inorderTraversal(TreeNode node, List<Integer> inorder) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, inorder);
        inorder.add(node.val);
        inorderTraversal(node.right, inorder);
    }

    private TreeNode buildTree(List<Integer> inorder, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        int val = inorder.get(mid);
        TreeNode node = new TreeNode(val);
        node.left = buildTree(inorder, left, mid - 1);
        node.right = buildTree(inorder, mid + 1, right);

        return node;
    }

    public static void main(String[] args) {
        BalanceBST solution = new BalanceBST();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println("Original BST Inorder:");
        solution.printInOrder(root);
        System.out.println();

        TreeNode balancedRoot = solution.balanceBST(root);

        System.out.println("Balanced BST Inorder:");
        solution.printInOrder(balancedRoot);
        System.out.println();
    }

    public void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
}
