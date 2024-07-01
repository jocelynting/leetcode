package greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();

        int[] test1 = {2, 3, 1, 1, 4};
        System.out.println(solution.canJump(test1)); // Output: true

        int[] test2 = {3, 2, 1, 0, 4};
        System.out.println(solution.canJump(test2)); // Output: false
    }
}
