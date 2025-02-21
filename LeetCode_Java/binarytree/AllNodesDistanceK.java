package binarytree;

import java.util.*;

public class AllNodesDistanceK {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> map = new HashMap<>();
        buildMap(root, null, map);

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);

        int count = 0;

        while (!queue.isEmpty()) {
            if (count == k) {
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                break;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if (cur.left != null && !visited.contains(cur.left)) {
                    queue.offer(cur.left);
                    visited.add(cur.left);
                }

                if (cur.right != null && !visited.contains(cur.right)) {
                    queue.offer(cur.right);
                    visited.add(cur.right);
                }

                TreeNode parent = map.get(cur);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                }
            }

            count++;
        }

        return result;
    }

    private void buildMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (node == null) {
            return;
        }

        map.put(node, parent);
        buildMap(node.left, node, map);
        buildMap(node.right, node, map);
    }

    public static void main(String[] args) {
        AllNodesDistanceK solution = new AllNodesDistanceK();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode target = root.left;  // target node is 5
        int K = 2;
        List<Integer> result1 = solution.distanceK(root, target, K);
        System.out.println(result1);  // Expected output: [7, 4, 1]

        target = root.left.right.right;  // target node is 4
        K = 1;
        List<Integer> result2 = solution.distanceK(root, target, K);
        System.out.println(result2);  // Expected output: [2]
    }
}
