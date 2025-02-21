package slidingwindow;

public class CountSubstringsSatisfyKConstraintI {
    public int countKConstraintSubstrings(String s, int k) {
        int result = 0;
        int left = 0, right = 0;
        int zero = 0, one = 0;

        while (right < s.length()) {
            if (s.charAt(right) == '0') {
                zero++;
            } else {
                one++;
            }
            right++;

            while (zero > k && one > k) {
                if (s.charAt(left) == '0') {
                    zero--;
                } else {
                    one--;
                }
                left++;
            }

            result += right - left;
        }

        return result;
    }

    public static void main(String[] args) {
        CountSubstringsSatisfyKConstraintI solution = new CountSubstringsSatisfyKConstraintI();
        System.out.println(solution.countKConstraintSubstrings("10101", 1));// Output: 12
        System.out.println(solution.countKConstraintSubstrings("1010101", 2));// Output: 25
        System.out.println(solution.countKConstraintSubstrings("11111", 1));// Output: 15
    }
}
