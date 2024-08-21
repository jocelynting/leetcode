package math;

public class TwoKeysKeyboard {
    public int minSteps(int n) {
        int result = 0;
        int d = 2;

        while (n > 1) {
            while (n % d == 0) {
                result += d;
                n /= d;
            }
            d++;
        }

        return result;
    }

    public static void main(String[] args) {
        TwoKeysKeyboard solution = new TwoKeysKeyboard();
        System.out.println(solution.minSteps(3));// Output: 3
        System.out.println(solution.minSteps(1));// Output: 0
        System.out.println(solution.minSteps(10));// Output: 7
    }
}
