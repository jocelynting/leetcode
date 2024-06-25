package binarysearch;

public class SqrtX {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SqrtX solution = new SqrtX();
        int x1 = 4;
        int x2 = 8;
        System.out.println(solution.mySqrt(x1));// Output: 2
        System.out.println(solution.mySqrt(x2));// Output: 2
    }
}
