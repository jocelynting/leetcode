package binarysearchtree;

public class InorderSuccessorBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        while (root != null) {

            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }

    public static void main(String[] args) {
        InorderSuccessorBST solution = new InorderSuccessorBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        TreeNode p = root.left.right; // Node with value 4
        System.out.println(solution.inorderSuccessor(root, p).val); // Output: 5

        p = root.left.left.left; // Node with value 1
        System.out.println(solution.inorderSuccessor(root, p).val); // Output: 2

        p = root; // Node with value 5
        System.out.println(solution.inorderSuccessor(root, p).val); // Output: 6
    }


}
