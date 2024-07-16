package binarytree;

import java.util.*;


public class CreateBinaryTreeFromDescriptions {
    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] des : descriptions) {
            int parentVal = des[0];
            int childVal = des[1];
            boolean left = des[2] == 1;

            TreeNode parent = map.computeIfAbsent(parentVal, k -> new TreeNode(k));
            TreeNode child = map.computeIfAbsent(childVal, k -> new TreeNode(k));

            if (left) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            children.add(childVal);
        }

        TreeNode root = null;
        for (int key : map.keySet()) {
            if (!children.contains(key)) {
                root = map.get(key);
                break;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        CreateBinaryTreeFromDescriptions sol = new CreateBinaryTreeFromDescriptions();

        int[][] descriptions1 = {
                {20, 15, 1},
                {20, 17, 0},
                {50, 20, 1},
                {50, 80, 0},
                {80, 19, 1}
        };
        TreeNode root1 = sol.createBinaryTree(descriptions1);
        printTree(root1); // Output: [50,20,80,15,17,19]

        int[][] descriptions2 = {
                {1, 2, 1},
                {2, 3, 0},
                {3, 4, 1},
        };
        TreeNode root2 = sol.createBinaryTree(descriptions2);
        printTree(root2); // Output: [1,2,null,null,3,4]
    }

    public static void printTree(TreeNode root) {
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
