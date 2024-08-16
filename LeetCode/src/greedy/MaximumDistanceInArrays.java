package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int distance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> cur = arrays.get(i);
            distance = Math.max(distance, Math.abs(cur.get(cur.size() - 1) - min));
            distance = Math.max(distance, Math.abs(max - cur.get(0)));

            min = Math.min(min, cur.get(0));
            max = Math.max(max, cur.get(cur.size() - 1));
        }

        return distance;
    }

    public static void main(String[] args) {
        MaximumDistanceInArrays solution = new MaximumDistanceInArrays();
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(1, 4));
        arrays.add(Arrays.asList(0, 5));
        arrays.add(Arrays.asList(2, 6));
        System.out.println(solution.maxDistance(arrays));  // Output: 6
    }

}
