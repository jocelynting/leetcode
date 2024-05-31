package bit;

public class NumberOfOneBits {
    public int hammingWeight(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {
            int bit = n >> i;
            if ((bit & 1) == 1) {
                result++;
            }
        }

//        while (n != 0) {
//            result += n & 1;
//            n >>>= 1;
//        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfOneBits solution = new NumberOfOneBits();

        int input1 = 0b00000000000000000000000000001011;
        int input2 = 0b00000000000000000000000010000000;
        int input3 = 0b11111111111111111111111111111101;

        System.out.println(solution.hammingWeight(input1)); // Output: 3
        System.out.println(solution.hammingWeight(input2)); // Output: 1
        System.out.println(solution.hammingWeight(input3)); // Output: 31
    }
}
