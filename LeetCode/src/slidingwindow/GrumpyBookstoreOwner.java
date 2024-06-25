package slidingwindow;

public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int cur = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                cur += customers[i];
            }
        }

        int addition = 0;
        int max = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                addition += customers[i];
            }

            if (i >= minutes && grumpy[i - minutes] == 1) {
                addition -= customers[i - minutes];

            }
            max = Math.max(max, addition);

        }

        return cur + max;
    }

    public static void main(String[] args) {
        GrumpyBookstoreOwner solution = new GrumpyBookstoreOwner();

        int[] customers1 = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy1 = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes1 = 3;
        System.out.println(solution.maxSatisfied(customers1, grumpy1, minutes1)); // Output: 16

        int[] customers2 = {3, 8, 8, 7, 1};
        int[] grumpy2 = {1, 0, 1, 0, 1};
        int minutes2 = 2;
        System.out.println(solution.maxSatisfied(customers2, grumpy2, minutes2)); // Output: 29

        int[] customers3 = {4, 10, 10};
        int[] grumpy3 = {1, 1, 0};
        int minutes3 = 2;
        System.out.println(solution.maxSatisfied(customers3, grumpy3, minutes3)); // Output: 24
    }
}
