package twopoint;

public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {
            long sum = (long) left * left + (long) right * right;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SumOfSquareNumbers solution = new SumOfSquareNumbers();

        int c1 = 5;
        int c2 = 3;
        int c3 = 4;

        System.out.println(solution.judgeSquareSum(c1)); // Output: true
        System.out.println(solution.judgeSquareSum(c2)); // Output: false
        System.out.println(solution.judgeSquareSum(c3)); // Output: true
    }
}
