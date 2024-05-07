package binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderInorderTraversal {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        root.left = arrayToTree(
                preorder,
                left,
                inorderIndexMap.get(rootValue) - 1
        );
        root.right = arrayToTree(
                preorder,
                inorderIndexMap.get(rootValue) + 1,
                right
        );
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderInorderTraversal solution = new ConstructBinaryTreeFromPreorderInorderTraversal();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = solution.buildTree(preorder, inorder);
        printInOrder(root);  // Expected: 9 3 15 20 7
    }
    private static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
}
