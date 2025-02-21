package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });

        List<int[]> result = new ArrayList<>();

        for (int[] p : people) {
            result.add(p[1], p);
        }

        return result.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight solution = new QueueReconstructionByHeight();

        int[][] people1 = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(solution.reconstructQueue(people1)));
        // Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]

        int[][] people2 = {{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}};
        System.out.println(Arrays.deepToString(solution.reconstructQueue(people2)));
        // Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
    }
}
