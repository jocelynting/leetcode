package bit;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        int[] nums1 = {2,2,1};
        int[] nums2 = {4,1,2,1,2};
        System.out.println(solution.singleNumber(nums1)); // Output: 1
        System.out.println(solution.singleNumber(nums2)); // Output: 4
    }
}
