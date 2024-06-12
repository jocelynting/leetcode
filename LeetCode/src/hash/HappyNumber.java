package hash;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = calculateSum(n);
        }

        return n == 1;
    }

    private int calculateSum(int n) {

        int sum = 0;

        while (n > 0) {
            int num = n % 10;
            n = n / 10;
            sum += num * num;
        }

        return sum;
    }

    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();

        int test1 = 19;
        System.out.println(test1 + " is happy: " + solution.isHappy(test1)); // Output: true

        int test2 = 2;
        System.out.println(test2 + " is happy: " + solution.isHappy(test2)); // Output: false
    }
}
