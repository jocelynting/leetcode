package bit;

public class NumberComplement {
    public int findComplement(int num) {
        int result = 0;
        int bit = 0;

        while (num > 0) {
            if ((num & 1) == 0) {
                result |= (1 << bit);
            }

            num >>= 1;
            bit++;
        }

        return result;

        /*
        int bit = Integer.toBinaryString(num).length();

        // 构造一个与 num 位数相同的掩码，全是 1 的二进制数
        int mask = (1 << bit) - 1;

        // 返回补数，即 num 与掩码异或
        return num ^ mask;
         */
    }

    public static void main(String[] args) {
        NumberComplement solution = new NumberComplement();
        System.out.println(solution.findComplement(5));// Output: 2
        System.out.println(solution.findComplement(1));// Output: 0
    }
}
