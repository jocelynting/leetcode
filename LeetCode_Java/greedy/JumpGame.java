package greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        /*
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
        }

        return true;
         */
        
        int last = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }

        return last == 0;
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();

        int[] test1 = {2, 3, 1, 1, 4};
        System.out.println(solution.canJump(test1)); // Output: true

        int[] test2 = {3, 2, 1, 0, 4};
        System.out.println(solution.canJump(test2)); // Output: false
    }
}
