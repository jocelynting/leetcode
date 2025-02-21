package bit;

public class SumTwoIntegers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b; // Calculate carry bits
            a = a ^ b;         // Calculate sum without carry
            b = carry << 1;    // Shift carry to the correct position
        }
        return a;
    }

    public static void main(String[] args) {
        SumTwoIntegers sol = new SumTwoIntegers();
        System.out.println(sol.getSum(11, 2)); // Output: 3
        System.out.println(sol.getSum(-2, 3)); // Output: 1
    }
}
