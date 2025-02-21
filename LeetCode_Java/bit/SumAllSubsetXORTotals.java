package bit;

import java.util.ArrayList;
import java.util.List;

public class SumAllSubsetXORTotals {

    public int subsetXORSum(int[] nums) {
//        return subsetXORSumByBacktracking(nums);
        return subsetXORSumByDFS(nums);
    }

    private int subsetXORSumByDFS(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int xorVal){
        if(nums.length == index){
            return xorVal;
        }

        int result = 0;
        // pick current num
        result += dfs(nums, index + 1, xorVal ^ nums[index]);
        // not pick current num
        result += dfs(nums, index + 1, xorVal);

        return result;
    }

    private int subsetXORSumByBacktracking(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, 0, new ArrayList<>(), result);

        int sum = 0;
        for (List<Integer> subset : result) {
            int subsetXORTotal = 0;
            for (int num : subset) {
                subsetXORTotal ^= num;
            }
            sum += subsetXORTotal;
        }
        return sum;
    }
    private void backtracking(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtracking(nums,i + 1,current,result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        SumAllSubsetXORTotals solution = new SumAllSubsetXORTotals();
        int[] nums1 = {1,3};
        int[] nums2 = {5,1,6};
        System.out.println(solution.subsetXORSum(nums1));// Output: 6
        System.out.println(solution.subsetXORSum(nums2));// Output: 28
    }
}
