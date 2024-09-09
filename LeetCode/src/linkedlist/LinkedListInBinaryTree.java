package linkedlist;

import binarytree.TreeNode;

public class LinkedListInBinaryTree {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode node) {
        if (head == null) {
            return true;
        }

        if (node == null) {
            return false;
        }

        if (head.val == node.val) {
            return dfs(head.next, node.left) || dfs(head.next, node.right);
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListInBinaryTree solution = new LinkedListInBinaryTree();

        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(8);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(1);
        root1.right.left = new TreeNode(2);
        root1.right.left.left = new TreeNode(6);
        root1.right.left.right = new TreeNode(8);
        root1.right.left.right.left = new TreeNode(1);
        root1.right.left.right.right = new TreeNode(3);

        System.out.println(solution.isSubPath(head1, root1));  // Output: true

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(4);
        root2.left.right = new TreeNode(2);

        System.out.println(solution.isSubPath(head2, root2));  // Output: true
    }
}
