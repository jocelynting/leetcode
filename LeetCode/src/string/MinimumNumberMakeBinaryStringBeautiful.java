package string;

public class MinimumNumberMakeBinaryStringBeautiful {
    public int minChanges(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumNumberMakeBinaryStringBeautiful solution = new MinimumNumberMakeBinaryStringBeautiful();
        System.out.println(solution.minChanges("0100")); // Output: 1
        System.out.println(solution.minChanges("10")); // Output: 1
        System.out.println(solution.minChanges("1111")); // Output: 0
    }
}
