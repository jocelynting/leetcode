package binarysearchtree;

public class BSTreeToGreaterSumTree {
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
        }

        return root;
    }

    public static void main(String[] args) {
        BSTreeToGreaterSumTree solution = new BSTreeToGreaterSumTree();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        System.out.println("Original BST Inorder:");
        solution.printInOrder(root);
        System.out.println();

        TreeNode gstRoot = solution.bstToGst(root);

        System.out.println("Greater Sum Tree Inorder:");
        solution.printInOrder(gstRoot);
        System.out.println();
    }

    public void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.val + " ");
            printInOrder(root.right);
        }
    }
}
