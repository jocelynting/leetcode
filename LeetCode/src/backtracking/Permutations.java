package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtracking(int [] nums, List<Integer> current, List<List<Integer>> result){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(current.contains(nums[i])) continue;
                current.add(nums[i]);
                backtracking(nums, current, result);
                current.remove(current.size() - 1);
            }
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
