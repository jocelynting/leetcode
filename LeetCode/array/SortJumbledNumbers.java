package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortJumbledNumbers {

    class Pair {
        int num;
        int mapValue;

        Pair(int num, int mapValue) {
            this.num = num;
            this.mapValue = mapValue;
        }
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int mapValue = mapNumber(mapping, nums[i]);
            pairs.add(new int[]{nums[i], mapValue});
        }

        Collections.sort(pairs, (a, b) -> a[1] - b[1]);

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = pairs.get(i)[0];
        }

        return result;
    }

    private int mapNumber(int[] mapping, int num) {
        StringBuilder sb = new StringBuilder();
        for (char ch : String.valueOf(num).toCharArray()) {
            sb.append(mapping[ch - '0']);
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        SortJumbledNumbers solution = new SortJumbledNumbers();
        int[] mapping = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums = {991, 338, 38};
        System.out.println(Arrays.toString(solution.sortJumbled(mapping, nums))); // Output: [338, 38, 991]
    }
}
