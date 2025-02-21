package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        backtracking(num, 0, result);
        return result;
    }

    private boolean backtracking(String num, int index, List<Integer> result) {
        if (index == num.length() && result.size() >= 3) {
            return true;
        }

        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && i > index) {
                break;
            }

            long number = Long.parseLong(num.substring(index, i + 1));
            if (number > Integer.MAX_VALUE) {
                break;
            }

            int size = result.size();
            if (size >= 2 && number > result.get(size - 1) + result.get(size - 2)) {
                break;
            }

            if (size <= 1 || number == result.get(size - 1) + result.get(size - 2)) {
                result.add((int) number);
                if (backtracking(num, i + 1, result)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SplitArrayIntoFibonacciSequence solution = new SplitArrayIntoFibonacciSequence();
        String num1 = "123456579";
        System.out.println(solution.splitIntoFibonacci(num1));  // Output: [123, 456, 579]

        String num2 = "11235813";
        System.out.println(solution.splitIntoFibonacci(num2));  // Output: [1, 1, 2, 3, 5, 8, 13]

        String num3 = "1101111";
        System.out.println(solution.splitIntoFibonacci(num3));  // Output: [11, 0, 11, 11]
    }
}
