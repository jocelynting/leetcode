package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                max = Math.max(max, node.val);
            }

            result.add(max);
        }

        return result;
    }

    public static void main(String[] args) {
        FindLargestValueEachTreeRow solution = new FindLargestValueEachTreeRow();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(9);
        List<Integer> result1 = solution.largestValues(root1);
        System.out.println(result1); // Output: [1, 3, 9]

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        List<Integer> result2 = solution.largestValues(root2);
        System.out.println(result2); // Output: [1, 3]

        TreeNode root3 = new TreeNode(-1);
        root3.left = new TreeNode(-2);
        root3.right = new TreeNode(-3);
        root3.left.left = new TreeNode(-4);
        root3.left.right = new TreeNode(-5);
        root3.right.left = new TreeNode(-6);
        List<Integer> result3 = solution.largestValues(root3);
        System.out.println(result3); // Output: [-1, -2, -4]
    }
}
