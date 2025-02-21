package math;

public class ReverseInteger {
    public int reverse(int x) {
        long result = 0;

        while (x != 0) {
            int num = x % 10;
            result = result * 10 + num;
            if (result <= Integer.MIN_VALUE || result >= Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }

        return (int) result;
        /*
        int result = 0;

        boolean negative = false;

        if (x < 0) {
            negative = true;
            x *= -1;
        }

        while (x > 0) {
            int num = x % 10;
            x /= 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > 7)) {
                return 0;
            }

            result = result * 10 + num;
        }

        return negative ? result * -1 : result;
         */
    }

    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();

        int result1 = solution.reverse(123);
        System.out.println("Reversed 123: " + result1); // Output: 321

        int result2 = solution.reverse(-123);
        System.out.println("Reversed -123: " + result2); // Output: -321

        int result3 = solution.reverse(1534236469);
        System.out.println("Reversed 1534236469: " + result3); // Output: 0 (overflow)
    }
}
