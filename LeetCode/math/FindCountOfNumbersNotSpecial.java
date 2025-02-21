package math;

public class FindCountOfNumbersNotSpecial {
    public int nonSpecialCount(int l, int r) {

        int sqrtL = (int) Math.ceil(Math.sqrt(l));

        int count = 0;
        for (int i = sqrtL; i * i <= r; i++) {
            if (isPrime(i)) {
                count += 1;
            }
        }

        return r - l + 1 - count;
    }

    private boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        FindCountOfNumbersNotSpecial solution = new FindCountOfNumbersNotSpecial();

        System.out.println(solution.nonSpecialCount(5, 7));// Output: 3
        System.out.println(solution.nonSpecialCount(4, 16));// Output: 11
    }
}
