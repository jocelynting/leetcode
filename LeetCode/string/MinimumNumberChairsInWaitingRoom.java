package string;

public class MinimumNumberChairsInWaitingRoom {
    public int minimumChairs(String s) {

        int min = 0;
        int result = 0;

        for (char ch: s.toCharArray()) {
            if (ch == 'E') {
                result += 1;
            }
            if (ch == 'L') {
                result -= 1;
            }

            min = Math.max(min, result);
        }


        return min;

    }

    public static void main(String[] args) {
        MinimumNumberChairsInWaitingRoom solution = new MinimumNumberChairsInWaitingRoom();

        String s1 = "EEEEEEE";
        System.out.println(solution.minimumChairs(s1));// Output: 7

        String s2 = "ELELEEL";
        System.out.println(solution.minimumChairs(s2));// Output: 2
    }
}
