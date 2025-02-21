package designclass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {
    Map<String, Integer> map;
    List<int[]> coordinates;

    public DetectSquares() {
        map = new HashMap<>();
        coordinates = new ArrayList<>();
    }

    public void add(int[] point) {
        coordinates.add(point);
        String key = point[0] + "," + point[1];
        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int count = 0;
        int px = point[0], py = point[1];

        for (int[] c : coordinates) {
            int x = c[0], y = c[1];
            if (px != x && py != y && Math.abs(px - x) == Math.abs(py - y)) {
                int c1 = map.getOrDefault(x + "," + py, 0);
                int c2 = map.getOrDefault(px + "," + y, 0);
                count += c1 * c2;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        DetectSquares solution = new DetectSquares();
        solution.add(new int[]{3, 10});
        solution.add(new int[]{11, 2});
        solution.add(new int[]{3, 2});
        System.out.println(solution.count(new int[]{11, 10})); // Output：1
        System.out.println(solution.count(new int[]{14, 8}));  // Output：0
    }
}
