package binarysearch;

public class MinimizedMaximumProductsDistributedToAnyStore {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 1;
        for (int q : quantities) {
            right = Math.max(right, q);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(quantities, n, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return left;
    }

    private boolean canDistribute(int[] quantities, int n, int target) {
        int count = 0;

        for (int q : quantities) {
            count += (q + target - 1) / target;
            ;
            if (count > n) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MinimizedMaximumProductsDistributedToAnyStore solution = new MinimizedMaximumProductsDistributedToAnyStore();

        int n1 = 6;
        int[] quantities1 = {11, 6};
        System.out.println(solution.minimizedMaximum(n1, quantities1)); // Output: 3

        int n2 = 7;
        int[] quantities2 = {15, 10, 10};
        System.out.println(solution.minimizedMaximum(n2, quantities2)); // Output: 5


    }
}
