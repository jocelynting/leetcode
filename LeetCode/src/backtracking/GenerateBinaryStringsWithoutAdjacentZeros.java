package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringsWithoutAdjacentZeros {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        backtracking(n, result, new StringBuilder(), '1');
        return result;
    }

    private void backtracking(int n, List<String> result, StringBuilder sb, char last) {
        if (n == sb.length()) {
            result.add(sb.toString());
            return;
        }

        sb.append('1');
        backtracking(n, result, sb, '1');
        sb.deleteCharAt(sb.length() - 1);

        if (last != '0') {
            sb.append('0');
            backtracking(n, result, sb, '0');
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateBinaryStringsWithoutAdjacentZeros solution = new GenerateBinaryStringsWithoutAdjacentZeros();
        System.out.println(solution.validStrings(3));// Output: ["010","011","101","110","111"]
        System.out.println(solution.validStrings(1));// Output: ["0","1"]
    }
}
