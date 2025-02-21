package array;

public class MakeTwoArraysEqualByReversingSubarrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count = new int[1001];

        for (int i = 0; i < target.length; i++) {
            count[target[i]]++;
        }

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]--;
            if (count[arr[i]] < 0) {
                return false;
            }
        }

        return true;

        /*
            Arrays.sort(target);
            Arrays.sort(arr);

            for (int i = 0; i < target.length; i++) {
                if (target[i] != arr[i]) {
                    return false;
                }
            }

            return true;
         */
    }

    public static void main(String[] args) {
        MakeTwoArraysEqualByReversingSubarrays solution = new MakeTwoArraysEqualByReversingSubarrays();

        int[] target1 = {1, 2, 3, 4};
        int[] arr1 = {2, 4, 1, 3};
        System.out.println(solution.canBeEqual(target1, arr1));// Output: true

        int[] target2 = {3, 7, 9};
        int[] arr2 = {3, 7, 11};
        System.out.println(solution.canBeEqual(target2, arr2));// Output: false
    }
}
