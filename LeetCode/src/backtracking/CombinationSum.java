package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        backtracking(candidates, target, 0, 0, results, res);

        return results;
    }

    private void backtracking(int[] candidates, int target, int sum, int startIndex, List<List<Integer>> results, List<Integer> list){

        if (sum > target) {
            return;
        }

        if (target == sum) {
            results.add(new ArrayList<>(list));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtracking(candidates, target, sum + candidates[i], i, results, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        CombinationSum solution = new CombinationSum();
        // Test case
        int[] candidates = {2, 3, 6, 7}; // Output: [[2,2,3],[7]]
        int target = 7;
        List<List<Integer>> result = solution.combinationSum(candidates, target);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
