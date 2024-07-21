package math;

public class VowelsGame {
    public boolean doesAliceWin(String s) {
        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        VowelsGame solution = new VowelsGame();
        System.out.println(solution.doesAliceWin("leetcode"));// Output: true
        System.out.println(solution.doesAliceWin("bbcd"));// Output: false
    }
}
