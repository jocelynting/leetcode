package bit;

public class NumberChangesMakeIntegersEqual {
    public int minChanges(int n, int k) {
        if (n == k) {
            return 0;
        }

        int result = 0;

        while (n > 0 || k > 0) {
            int bn = n & 1;
            int kn = k & 1;

            if (kn == 1 && bn == 0) {
                return -1;
            }

            if (kn == 0 && bn == 1) {
                result++;
            }

            n >>= 1;
            k >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        NumberChangesMakeIntegersEqual solution = new NumberChangesMakeIntegersEqual();
        System.out.println(solution.minChanges(13, 4));// Output: 2
        System.out.println(solution.minChanges(21, 21));// Output: 0
        System.out.println(solution.minChanges(14, 13));// Output: -1
    }
}
