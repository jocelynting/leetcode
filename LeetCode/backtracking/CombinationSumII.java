package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtracking(int[] candidates, int target, int start, List<Integer> cur, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            cur.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }

    /*
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0, 0, result, new ArrayList<>());
        return result;
    }

    private void backtracking(int[] candidates, int target, int sum, int index, List<List<Integer>> result, List<Integer> cur) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            cur.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], i + 1, result, cur);
            cur.remove(cur.size() - 1);
        }
    }
     */
    public static void main(String[] args) {
        CombinationSumII solution = new CombinationSumII();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = solution.combinationSum2(candidates, target);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
        // Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
    }
}
