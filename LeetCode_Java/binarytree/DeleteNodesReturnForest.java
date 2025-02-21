package binarytree;

import java.util.*;

public class DeleteNodesReturnForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
//        return delNodesByDFS(root, to_delete);
        return delNodesByBFS(root, to_delete);
    }

    private List<TreeNode> delNodesByDFS(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int value : to_delete) {
            set.add(value);
        }

        List<TreeNode> result = new ArrayList<>();
        root = dfs(root, set, result);
        if (root != null) {
            result.add(root);
        }

        return result;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> set, List<TreeNode> result) {
        if (node == null) {
            return null;
        }

        node.left = dfs(node.left, set, result);
        node.right = dfs(node.right, set, result);

        if (set.contains(node.val)) {
            if (node.left != null) {
                result.add(node.left);
            }
            if (node.right != null) {
                result.add(node.right);
            }

            return null;
        }
        return node;
    }

    private List<TreeNode> delNodesByBFS(TreeNode root, int[] to_delete) {

        List<TreeNode> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Set<Integer> set = new HashSet<>();
        for (int value : to_delete) {
            set.add(value);
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur.left != null) {
                queue.offer(cur.left);
                if (set.contains(cur.left.val)) {
                    cur.left = null;
                }
            }

            if (cur.right != null) {
                queue.offer(cur.right);
                if (set.contains(cur.right.val)) {
                    cur.right = null;
                }
            }

            if (set.contains(cur.val)) {
                if (cur.left != null) {
                    result.add(cur.left);
                }
                if (cur.right != null) {
                    result.add(cur.right);
                }
            }
        }

        if (!set.contains(root.val)) {
            result.add(root);
        }

        return result;
    }

    public static void main(String[] args) {
        DeleteNodesReturnForest solution = new DeleteNodesReturnForest();

        // Construct the tree: [1,2,3,4,5,6,7]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int[] to_delete = {3, 5};

        List<TreeNode> forest = solution.delNodes(root, to_delete);// Output: [[1,2,null,4],[6],[7]]

        for (TreeNode tree : forest) {
            printTree(tree);
            System.out.println();
        }
    }

    private static void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
}
