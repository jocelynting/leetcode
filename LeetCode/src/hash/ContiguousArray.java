package hash;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        ContiguousArray solution = new ContiguousArray();

        int[] nums1 = {0, 1};
        System.out.println(solution.findMaxLength(nums1));// Output: 2

        int[] nums2 = {0, 1, 0};
        System.out.println(solution.findMaxLength(nums2));// Output: 2

        int[] nums3 = {0, 0, 1, 0, 0, 0, 1, 1};
        System.out.println(solution.findMaxLength(nums3));// Output: 6
    }
}
