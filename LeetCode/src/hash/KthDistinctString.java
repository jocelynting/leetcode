package hash;

import java.util.HashMap;
import java.util.Map;

public class KthDistinctString {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : arr) {
            if (map.get(s) == 1) {
                k--;
                if (k == 0) {
                    return s;
                }
            }
        }

        return "";
    }

    public static void main(String[] args) {
        KthDistinctString solution = new KthDistinctString();

        String[] arr1 = {"d", "b", "c", "b", "c", "a"};
        System.out.println(solution.kthDistinct(arr1, 2));// Output: "a"

        String[] arr2 = {"aaa", "aa", "a"};
        System.out.println(solution.kthDistinct(arr2, 1));// Output: "aaa"
    }
}
