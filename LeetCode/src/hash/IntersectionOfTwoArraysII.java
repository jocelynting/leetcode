package hash;

import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) > 0) {
                result.add(n);
                map.put(n, map.get(n) - 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII solution = new IntersectionOfTwoArraysII();

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(solution.intersect(nums1, nums2))); // Output: [2, 2]

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solution.intersect(nums3, nums4))); // Output: [4, 9]
    }
}
