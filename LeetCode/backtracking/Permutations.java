package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtracking(results, new ArrayList<>(), nums);
        return results;
    }

    private void backtracking(List<List<Integer>> results, List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int num : nums) {
            if (current.contains(num)) continue;
            current.add(num);
            backtracking(results, current, nums);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();

        // Test case
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = solution.permute(nums);
        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
