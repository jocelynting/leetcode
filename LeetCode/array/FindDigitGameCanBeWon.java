package array;

public class FindDigitGameCanBeWon {
    public boolean canAliceWin(int[] nums) {

        int singleSum = 0, doubleSum = 0;

        for (int num : nums) {
            if (num < 10) {
                singleSum += num;
            } else {
                doubleSum += num;
            }
        }

        return singleSum != doubleSum;
    }

    public static void main(String[] args) {
        FindDigitGameCanBeWon solution = new FindDigitGameCanBeWon();

        int[] nums1 = {1, 2, 3, 4, 10};
        System.out.println(solution.canAliceWin(nums1));// Output: false

        int[] nums2 = {1, 2, 3, 4, 5, 14};
        System.out.println(solution.canAliceWin(nums2));// Output: true
    }
}
