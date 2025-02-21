package math;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
//        return lexicalOrderByDFS(n);
        return lexicalOrderByIteration(n);
    }

    public List<Integer> lexicalOrderByDFS(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }

        return result;
    }

    private void dfs(int cur, int n, List<Integer> result) {
        if (cur > n) {
            return;
        }

        result.add(cur);

        for (int i = 0; i <= 9; i++) {
            int next = cur * 10 + i;
            if (next > n) {
                return;
            }
            dfs(next, n, result);
        }
    }

    public List<Integer> lexicalOrderByIteration(int n) {
        List<Integer> result = new ArrayList<>();
        int cur = 1;

        for (int i = 0; i < n; i++) {
            result.add(cur);

            if (cur * 10 <= n) {
                cur *= 10;
            } else {
                while (cur % 10 == 9 || cur + 1 > n) {
                    cur /= 10;
                }
                cur++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LexicographicalNumbers solution = new LexicographicalNumbers();
        int n1 = 13;
        System.out.println(solution.lexicalOrder(n1)); // Output: [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]

        int n2 = 2;
        System.out.println(solution.lexicalOrder(n2)); // Output: [1, 2]
    }
}
