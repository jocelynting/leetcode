package hash;

import java.util.HashMap;
import java.util.Map;

public class CheckArrayPairsDivisibleByK {

    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int r = ((num % k) + k) % k;
            map.put(r, map.getOrDefault(r, 0) + 1);
        }

        for (int r : map.keySet()) {
            int count = map.get(r);
            if (r == 0) {
                if (count % 2 != 0) {
                    return false;
                }
            } else {
                int sub = k - r;
                if (map.getOrDefault(sub, 0) != count) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckArrayPairsDivisibleByK solution = new CheckArrayPairsDivisibleByK();
        int[] arr1 = {3, 8, 17, 12};
        int k1 = 5;
        System.out.println(solution.canArrange(arr1, k1)); // Output: true

        int[] arr2 = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k2 = 5;
        System.out.println(solution.canArrange(arr2, k2)); // Output: true

        int[] arr3 = {1, 2, 3, 4, 5, 6};
        int k3 = 7;
        System.out.println(solution.canArrange(arr3, k3)); // Output: true

        int[] arr4 = {1, 2, 3, 4, 5, 6};
        int k4 = 10;
        System.out.println(solution.canArrange(arr4, k4)); // Output: false
    }
}
