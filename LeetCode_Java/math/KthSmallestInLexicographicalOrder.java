package math;

public class KthSmallestInLexicographicalOrder {

    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;

        while (k > 0) {
            int count = countNumbersInRange(cur, n);

            if (count <= k) {
                k -= count;
                cur++;
            } else {
                cur *= 10;
                k--;
            }
        }

        return cur;
    }

    private int countNumbersInRange(int prefix, int n) {
        long cur = prefix, next = prefix + 1;
        int count = 0;

        while (cur <= n) {
            count += (int) (Math.min(n + 1, next) - cur);
            cur *= 10;
            next *= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        KthSmallestInLexicographicalOrder solution = new KthSmallestInLexicographicalOrder();
        int n1 = 13, k1 = 2;
        System.out.println(solution.findKthNumber(n1, k1)); // Output: 10

        int n2 = 100, k2 = 10;
        System.out.println(solution.findKthNumber(n2, k2)); // Output: 17
    }
}
