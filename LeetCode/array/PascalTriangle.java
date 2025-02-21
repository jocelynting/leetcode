package array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        for (int i = 1; i < numRows; i++) {
            List<Integer> pre = result.get(i - 1);
            List<Integer> cur = new ArrayList<>();

            cur.add(1);

            for (int j = 1; j < i; j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }

            cur.add(1);
            result.add(cur);
        }

        return result;
    }

    public static void main(String[] args) {
        PascalTriangle solution = new PascalTriangle();
        int numRows = 5;
        System.out.println(solution.generate(numRows));// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    }
}
