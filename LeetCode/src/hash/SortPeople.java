package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortPeople {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        Arrays.sort(heights);

        String[] result = new String[names.length];
        int index = 0;

        for (int i = heights.length - 1; i >= 0; i--) {
            result[index++] = map.get(heights[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        SortPeople solution = new SortPeople();
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};

        System.out.println(Arrays.toString(solution.sortPeople(names, heights))); // Output: [Mary, Emma, John]
    }

}
