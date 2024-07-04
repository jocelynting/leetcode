package string;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strings, (a, b) -> (b + a).compareTo(a + b));

        if (strings[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String s : strings) {
            result.append(s);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LargestNumber solution = new LargestNumber();
        System.out.println(solution.largestNumber(new int[]{10, 2})); // Output: "210"
        System.out.println(solution.largestNumber(new int[]{3, 30, 34, 5, 9})); // Output: "9534330"
        System.out.println(solution.largestNumber(new int[]{0, 0})); // Output: "0"
    }
}
