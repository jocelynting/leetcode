package greedy;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        int length = flowerbed.length;

        for (int i = 0; i < length; i = i + 2) {

            if (flowerbed[i] == 0) {
                boolean right = (i + 1 == length) || flowerbed[i + 1] == 0;

                if (right) {
                    n--;
                    if (n == 0) {
                        return true;
                    }
                } else {
                    i++;
                }
            }
        }

        return n == 0;
    }

    public static void main(String[] args) {
        CanPlaceFlowers solution = new CanPlaceFlowers();
        int[] flowerbed1 = {1, 0, 0, 0, 1};
        System.out.println(solution.canPlaceFlowers(flowerbed1, 1)); // Output: true

        int[] flowerbed2 = {1, 0, 0, 0, 1};
        System.out.println(solution.canPlaceFlowers(flowerbed2, 2)); // Output: false

        int[] flowerbed3 = {1, 0, 1, 0, 1, 0, 1};
        System.out.println(solution.canPlaceFlowers(flowerbed3, 1)); // Output: false

        int[] flowerbed4 = {1, 0, 0, 0, 1, 0, 0};
        System.out.println(solution.canPlaceFlowers(flowerbed4, 2)); // Output: true
    }
}
