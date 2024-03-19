package backtracking;

import java.util.HashSet;
import java.util.Set;

public class NQueensII {

    private int result;

    public int totalNQueens(int n) {
        result = 0;
        Set<Integer> cols = new HashSet<>();
        Set<Integer> positiveDiagonals = new HashSet<>();
        Set<Integer> negativeDiagonals = new HashSet<>();

        backtracking(n,0,cols,positiveDiagonals,negativeDiagonals);

        return result;
    }

    private void backtracking(int n, int r, Set<Integer> cols, Set<Integer>positiveDiagonals, Set<Integer>negativeDiagonals){
        if (r == n){
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (cols.contains(i) || positiveDiagonals.contains(r - i) || negativeDiagonals.contains(r + i)){
                continue;
            }
            cols.add(i);
            positiveDiagonals.add(r - i);
            negativeDiagonals.add(r + i);
            backtracking(n, r + 1, cols, positiveDiagonals, negativeDiagonals);
            cols.remove(i);
            positiveDiagonals.remove(r - i);
            negativeDiagonals.remove(r + i);
        }
    }

    public static void main(String[] args) {
        NQueensII solution = new NQueensII();
        int n = 4;
        System.out.println(solution.totalNQueens(n)); // Output: 2
    }


}
