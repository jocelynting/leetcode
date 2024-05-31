package bit;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int lowbit = xor & (-xor);

        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & lowbit) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        SingleNumberIII solution = new SingleNumberIII();
        int[] nums1 = {1,2,1,3,2,};
        int[] nums2 = {-1,0};
        System.out.println(solution.singleNumber(nums1)); // Output:[3,5]
        System.out.println(solution.singleNumber(nums2)); // Output: [-1,0]
    }
}
