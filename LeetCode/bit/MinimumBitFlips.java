package bit;

public class MinimumBitFlips {
    public int minBitFlips(int start, int goal) {
        // XOR of two bits returns 1 when the bits are different and 0 when they are the same.
        int xor = start ^ goal;

        return Integer.bitCount(xor);
    }

    public static void main(String[] args) {
        MinimumBitFlips solution = new MinimumBitFlips();
        System.out.println(solution.minBitFlips(10, 7));  // Output: 3
        System.out.println(solution.minBitFlips(3, 4));   // Output: 3
    }
}
