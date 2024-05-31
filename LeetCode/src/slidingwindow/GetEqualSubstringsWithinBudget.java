package slidingwindow;

public class GetEqualSubstringsWithinBudget {

    public int equalSubstring(String s, String t, int maxCost) {

        int left = 0, right = 0;
        int max = 0;
        int cur = 0;

        while (right < s.length()) {
            cur += Math.abs(s.charAt(right) - t.charAt(right));

            while (cur > maxCost) {
                cur -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            max = Math.max(max, right - left + 1);

            right++;
        }

        return max;
    }

    public static void main(String[] args) {
        GetEqualSubstringsWithinBudget solution = new GetEqualSubstringsWithinBudget();
        String s1 = "abcd";
        String t1 = "bcdf";
        int maxCost1 = 3;
        System.out.println(solution.equalSubstring(s1,t1,maxCost1));// Output: 3

        String s2 = "abcd";
        String t2 = "cdef";
        int maxCost2 = 3;
        System.out.println(solution.equalSubstring(s2,t2,maxCost2));// Output: 1

        String s3 = "abcd";
        String t3 = "acde";
        int maxCost3 = 0;
        System.out.println(solution.equalSubstring(s3,t3,maxCost3));// Output: 1
    }
}
