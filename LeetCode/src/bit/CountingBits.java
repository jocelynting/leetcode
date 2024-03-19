package bit;

public class CountingBits {
    public int[] countBits(int n) {
        int[] count = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            count[i] = count[i >> 1] + (i & 1);
        }

        return count;
    }

    public static void main(String[] args) {
        CountingBits solution = new CountingBits();

        // Test case
        int num = 5;
        int[] result = solution.countBits(num);
        System.out.println("Counting bits for numbers up to " + num + ":");
        for (int i = 0; i <= num; i++) {
            System.out.print(result[i] + " ");
        }
        // Output: 0 1 1 2 1 2
    }
}
