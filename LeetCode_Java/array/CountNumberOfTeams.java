package array;

public class CountNumberOfTeams {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            int leftSmall = 0, leftLarge = 0;
            int rightSmall = 0, rightLarge = 0;

            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftSmall++;
                } else {
                    leftLarge++;
                }
            }

            for (int k = i + 1; k < n; k++) {
                if (rating[k] < rating[i]) {
                    rightSmall++;
                } else {
                    rightLarge++;
                }
            }

            result += leftSmall * rightLarge + leftLarge * rightSmall;
        }

        return result;
    }

    public static void main(String[] args) {
        CountNumberOfTeams solution = new CountNumberOfTeams();

        int[] rating1 = {2, 5, 3, 4, 1};
        System.out.println(solution.numTeams(rating1)); // Output: 3

        int[] rating2 = {2, 1, 3};
        System.out.println(solution.numTeams(rating2)); // Output: 0

        int[] rating3 = {1, 2, 3, 4};
        System.out.println(solution.numTeams(rating3)); // Output: 4
    }
}
