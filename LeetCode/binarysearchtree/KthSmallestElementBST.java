package binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KthSmallestElementBST {
    int count;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = 0;
        inorderTraversal(root, k);
        return result;
    }

    private void inorderTraversal(TreeNode node, int k) {
        if (node == null) {
            return ;
        }

        inorderTraversal(node.left, k);
        count++;
        if (count == k){
            result = node.val;
            return;
        }
        inorderTraversal(node.right,k);
    }

//    public int kthSmallest(TreeNode root, int k) {
//        List<Integer> results = new ArrayList<>();
//        inorderTraversal(root, results);
//        return results.get(k - 1);
//    }
//
//    private void inorderTraversal(TreeNode node, List<Integer> results) {
//        if (node == null) {
//            return ;
//        }
//
//        inorderTraversal(node.left, results);
//        results.add(node.val);
//        inorderTraversal(node.right, results);
//    }


    public static void main(String[] args) {
        KthSmallestElementBST solution = new KthSmallestElementBST();

        // Test case
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int k = 1;

        System.out.println("Kth Smallest Element: " + solution.kthSmallest(root, k)); // Output: 1
    }

}
