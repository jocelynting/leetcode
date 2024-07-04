package binarytree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (results.size() % 2 != 0) {
                    level.offerFirst(node.val);
                } else {
                    level.offerLast(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            results.add(new ArrayList<>(level));
        }

        return results;

        /*
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean reverse = false;
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            List<Integer> cur = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                cur.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (level % 2 == 1) {
                Collections.reverse(cur);
            }

            result.add(cur);
        }

        return result;
        */
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();

        // Test case
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Zigzag Level Order Traversal: " + solution.zigzagLevelOrder(root)); // Output: [[3], [20, 9], [15, 7]]
    }
}
