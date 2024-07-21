package greedy;

public class MaximumOperationsMoveOnesToEnd {

    public int maxOperations(String s) {
        int result = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                count++;
            } else if (i > 0 && s.charAt(i - 1) == '1') {
                result += count;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MaximumOperationsMoveOnesToEnd solution = new MaximumOperationsMoveOnesToEnd();
        System.out.println(solution.maxOperations("1001101"));// Output: 4
        System.out.println(solution.maxOperations("00111"));// Output: 0
    }
}
