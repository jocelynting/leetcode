package hash;

import java.util.HashMap;
import java.util.Map;

public class FindNumberOfGoodPairsII {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {

        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums1) {
            if (num % k != 0) {
                continue;
            }
            int val = num / k;
            for (int i = 1; i * i <= val; i++) {
                if (val % i == 0) {
                    int count = counter.getOrDefault(i, 0) + 1;
                    counter.put(i, count);
                    if (i * i < val) {
                        count = counter.getOrDefault(val / i, 0) + 1;
                        counter.put(val / i, count);
                    }
                }
            }
        }

        long result = 0;
        for (int num : nums2) {
            result += counter.getOrDefault(num, 0);
        }

        return result;
    }

    public static void main(String[] args) {
        FindNumberOfGoodPairsII solution = new FindNumberOfGoodPairsII();
        int[] nums1 = {1,2,4,12};
        int[] nums2 = {2,4};
        int k1 = 3;
        System.out.println(solution.numberOfPairs(nums1,nums2, k1));// Output: 2
        int[] nums3 = {1, 3, 4};
        int[] nums4 = {1, 3, 4};
        int k2 = 1;
        System.out.println(solution.numberOfPairs(nums3,nums4, k2));// Output: 5
    }
}
