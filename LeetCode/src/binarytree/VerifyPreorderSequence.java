package binarytree;

public class VerifyPreorderSequence {
    private int index;

    public boolean verifyPreorder(int[] preorder) {
        index = 0;
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(int[] preorder, int min, int max) {
        if (index == preorder.length) {
            return true;
        }

        int root = preorder[index];
        if (root <= min || root >= max) {
            return false;
        }
        index++;

        boolean left = dfs(preorder, min, root);
        boolean right = dfs(preorder, root, max);

        return left || right;
    }

    public static void main(String[] args) {
        VerifyPreorderSequence solution = new VerifyPreorderSequence();
        System.out.println(solution.verifyPreorder(new int[]{5, 2, 1, 3, 6})); // true
        System.out.println(solution.verifyPreorder(new int[]{5, 2, 6, 1, 3})); // false
    }
}
