package binarytree;

import java.util.ArrayList;
import java.util.List;

public class GoodLeafNodesPairs {
    private int count;

    public int countPairs(TreeNode root, int distance) {
        count = 0;
        dfs(root, distance);
        return count;
    }

    private List<Integer> dfs(TreeNode node, int distance) {
        List<Integer> distances = new ArrayList<Integer>();

        if (node == null) {
            return distances;
        }

        if (node.left == null && node.right == null) {
            distances.add(0);
            return distances;
        }

        List<Integer> left = dfs(node.left, distance);
        List<Integer> right = dfs(node.right, distance);

        for (int i = 0; i < left.size(); i++) {
            int dist = left.get(i) + 1;
            left.set(i, dist);
            if (dist <= distance) {
                distances.add(dist);
            }
        }

        for (int i = 0; i < right.size(); i++) {
            int dist = right.get(i) + 1;
            right.set(i, dist);
            if (dist <= distance) {
                distances.add(dist);
            }
        }
        
        for (int ld : left) {
            for (int rd : right) {
                if (ld + rd <= distance) {
                    count++;
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        GoodLeafNodesPairs solution = new GoodLeafNodesPairs();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(solution.countPairs(root, 3));// Output: 2
    }
}
