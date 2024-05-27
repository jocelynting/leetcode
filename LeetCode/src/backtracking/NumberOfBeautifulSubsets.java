package backtracking;

public class NumberOfBeautifulSubsets {

    private int result;
    private int[] counter;
    public int beautifulSubsets(int[] nums, int k) {
        result = -1; // eliminate empty array
        counter = new int[2 * k + 1001];
        backtracking(nums, k, 0);
        return result;
    }

    private void backtracking(int[] nums, int k, int start) {
        if (start == nums.length) {
            result += 1;
            return;
        }

        backtracking(nums, k, start + 1);

        int num = nums[start] + k;
        if (counter[num - k] == 0 && counter[num + k] == 0) {
            counter[num]++;
            backtracking(nums, k, start + 1);
            counter[num]--;
        }
    }

    public static void main(String[] args) {
        NumberOfBeautifulSubsets soltion = new NumberOfBeautifulSubsets();
        int[] nums1 = {2,4,6};
        int k1 = 2;
        int[] nums2 = {1};
        int k2 = 1;

        System.out.println(soltion.beautifulSubsets(nums1, k1));// Output: 4
        System.out.println(soltion.beautifulSubsets(nums2, k2));// Output: 1
    }
}
