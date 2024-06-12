package twopoint;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int finder = nums[0];
        while (finder != slow) {
            finder = nums[finder];
            slow = nums[slow];
        }

        return slow;
    }

    public static void main(String[] args) {
        FindDuplicateNumber solution = new FindDuplicateNumber();

        int[] test1 = {2,5,9,6,9,3,8,9,7,1};
        System.out.println(solution.findDuplicate(test1));  // Output: 2

        int[] test2 = {3, 1, 3, 4, 2};
        System.out.println(solution.findDuplicate(test2));  // Output: 3

        int[] test3 = {1, 1};
        System.out.println(solution.findDuplicate(test3));  // Output: 1

        int[] test4 = {1, 1, 2};
        System.out.println(solution.findDuplicate(test4));  // Output: 1
    }
}
