package array;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        int[] result = new int[n + 1];
        result[0] = 1;

        return result;
    }

    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 3}))); // [1, 2, 4]
        System.out.println(Arrays.toString(solution.plusOne(new int[]{4, 3, 2, 1}))); // [4, 3, 2, 2]
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9, 9, 9}))); // [1, 0, 0, 0]
    }
}
