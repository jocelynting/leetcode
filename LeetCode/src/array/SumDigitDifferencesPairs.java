package array;

public class SumDigitDifferencesPairs {
    public long sumDigitDifferences(int[] nums) {
        long result = 0;
        int[][] count = new int[Integer.toString(nums[0]).length()][10];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; num > 0; j++) {
                int digit = num % 10;
                result += i - count[j][digit];
                count[j][digit]++;
                num /= 10;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SumDigitDifferencesPairs solution = new SumDigitDifferencesPairs();
        int[] nums1 = {13,23,12};
        int[] nums2 = {10,10,10,10};
        System.out.println(solution.sumDigitDifferences(nums1));// Output: 4
        System.out.println(solution.sumDigitDifferences(nums2));// Output: 0
    }
}
