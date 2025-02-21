package bit;

public class ReverseBits {

    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            result = (result << 1) | bit;
            n >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();

        int num1 = 0b00000010100101000001111010011100;
        int reversed1 = solution.reverseBits(num1);
        System.out.println("Test Case 1: " + Integer.toBinaryString(reversed1)); // Output: 00111001011110000010100101000000

        int num2 = 0b11111111111111111111111111111101;
        int reversed2 = solution.reverseBits(num2);
        System.out.println("Test Case 2: " + Integer.toBinaryString(reversed2)); // Output: 10111111111111111111111111111111

        int num3 = 0b00000000000000000000000000000000;
        int reversed3 = solution.reverseBits(num3);
        System.out.println("Test Case 3: " + Integer.toBinaryString(reversed3)); // Output: 00000000000000000000000000000000

        int num4 = 0b00000000000000000000000000000001;
        int reversed4 = solution.reverseBits(num4);
        System.out.println("Test Case 4: " + Integer.toBinaryString(reversed4)); // Output: 10000000000000000000000000000000
    }
}
