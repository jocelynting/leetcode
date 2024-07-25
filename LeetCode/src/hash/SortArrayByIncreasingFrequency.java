package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(b[0], a[0]);
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] result = new int[nums.length];
        int index = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int value = cur[0];
            int count = cur[1];
            for (int i = 0; i < count; i++) {
                result[index++] = value;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SortArrayByIncreasingFrequency solution = new SortArrayByIncreasingFrequency();
        int[] nums1 = {1, 1, 2, 2, 2, 3};
        System.out.println(Arrays.toString(solution.frequencySort(nums1))); // Output: [3, 1, 1, 2, 2, 2]

        int[] nums2 = {2, 3, 1, 3, 2};
        System.out.println(Arrays.toString(solution.frequencySort(nums2))); // Output: [1, 3, 3, 2, 2]

        int[] nums3 = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
        System.out.println(Arrays.toString(solution.frequencySort(nums3))); // Output: [5, -1, 4, 4, -6, -6, 1, 1, 1]
    }
}
