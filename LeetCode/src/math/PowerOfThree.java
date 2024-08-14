package math;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 3 != 0) {
            return false;
        }

        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        PowerOfThree solution = new PowerOfThree();
        System.out.println(solution.isPowerOfThree(27));// Output: true
        System.out.println(solution.isPowerOfThree(0));// Output: false
        System.out.println(solution.isPowerOfThree(-1));// Output: false
    }
}
