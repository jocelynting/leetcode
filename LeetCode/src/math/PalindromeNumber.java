package math;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {

        // negative number and number end with 0
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reversed = 0;
        int origin = x;

        while (origin != 0) {
            int num = origin % 10;
            reversed = reversed * 10 + num;
            origin /= 10;
        }

        return reversed == x;
    }

    public static void main(String[] args) {
        PalindromeNumber solution = new PalindromeNumber();
        int x1 = 121;
        int x2 = -121;
        System.out.println(solution.isPalindrome(x1));// Output: true
        System.out.println(solution.isPalindrome(x2));// Output: false
    }
}
