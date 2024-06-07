package hash;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> map.get(n2) - map.get(n1));
//
//        for (int num : map.keySet()) {
//            maxHeap.offer(num);
//        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((n1, n2) -> map.get(n2) - map.get(n1));

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
//            result[i] = maxHeap.poll();
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        TopKFrequent solution = new TopKFrequent();

        // Test case
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        System.out.println(Arrays.toString(result)); // Expected output: [1, 2]
    }
}
