package math;

public class FindChildHasBallAfterKSeconds {
    public int numberOfChild(int n, int k) {
        int round = k / (n - 1);

        int num = k % (n - 1);

        int result = 0;

        if (round % 2 == 0) {
            result = num;
        } else {
            result = n - num - 1;
        }

        return result;
    }

    public static void main(String[] args) {
        FindChildHasBallAfterKSeconds solution = new FindChildHasBallAfterKSeconds();
        int n1 = 3, k1 = 5;
        System.out.println(solution.numberOfChild(n1, k1));// Output: 1
        int n2 = 5, k2 = 6;
        System.out.println(solution.numberOfChild(n2, k2));// Output: 2
    }
}
