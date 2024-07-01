package array;

public class ThreeConsecutiveOdds {

    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;

        for (int num : arr) {
            if (num % 2 != 0) {
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ThreeConsecutiveOdds solution = new ThreeConsecutiveOdds();

        int[] arr1 = {2, 6, 4, 1};
        System.out.println(solution.threeConsecutiveOdds(arr1)); // Output: false

        int[] arr2 = {1, 2, 34, 3, 4, 5, 7, 23, 12};
        System.out.println(solution.threeConsecutiveOdds(arr2)); // Output: true

        int[] arr3 = {1, 3, 5, 7};
        System.out.println(solution.threeConsecutiveOdds(arr3)); // Output: true

        int[] arr4 = {2, 4, 6, 8};
        System.out.println(solution.threeConsecutiveOdds(arr4)); // Output: false
    }
}
