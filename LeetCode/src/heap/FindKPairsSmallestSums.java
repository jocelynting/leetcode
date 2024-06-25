package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );

        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[]{i, 0});
        }

        while (k > 0 && !minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int i = cur[0];
            int j = cur[1];
            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{i, j + 1});
            }
            k--;
        }

        return result;
    }

    public static void main(String[] args) {
        FindKPairsSmallestSums solution = new FindKPairsSmallestSums();
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k1 = 3;
        System.out.println(solution.kSmallestPairs(nums1, nums2, k1));// Output: [[1,2],[1,4],[1,6]]

        int[] nums3 = {1, 1, 2};
        int[] nums4 = {1, 2, 3};
        int k2 = 2;
        System.out.println(solution.kSmallestPairs(nums3, nums4, k2));// Output: [[1,1],[1,1]]
    }

}
