package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CousinsInBinaryTreeII {
    public TreeNode replaceValueInTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> levelSums = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            levelSums.add(sum);
        }

        queue.offer(root);
        int level = 1;
        root.val = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int cousinSum = (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);

                if (node.left != null) {
                    node.left.val = levelSums.get(level) - cousinSum;
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    node.right.val = levelSums.get(level) - cousinSum;
                    queue.offer(node.right);
                }
            }

            level++;
        }

        return root;
    }

    public static void main(String[] args) {
        CousinsInBinaryTreeII cousinsInBinaryTreeII = new CousinsInBinaryTreeII();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(10);
        root.right.right = new TreeNode(7);
        TreeNode result = cousinsInBinaryTreeII.replaceValueInTree(root);
        printTree(result);// Output: 0 0 0 7 7 null 11 null null null null null null
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.print(node.val + " ");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                System.out.print("null ");
            }
        }
        System.out.println();
    }
}
