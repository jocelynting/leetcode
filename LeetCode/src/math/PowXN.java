package math;

public class PowXN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        long power = n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        double result = 1;
        double cur = x;

        while (power > 0) {
            if (power % 2 == 1) {
                result *= cur;
            }
            cur *= cur;
            power /= 2;
        }

        return result;
    }

    public static void main(String[] args) {
        PowXN solution = new PowXN();
        System.out.println(solution.myPow(2.00000, 10));  // Output: 1024.00000
        System.out.println(solution.myPow(2.10000, 3));   // Output: 9.26100
        System.out.println(solution.myPow(2.00000, -2));  // Output: 0.25000
        System.out.println(solution.myPow(0.00001, 2147483647));  // Output: 0.0 (due to floating-point precision)
        System.out.println(solution.myPow(1.00000, -2147483648));  // Output: 1.0
    }
}
