package binarysearch;

public class RandomPickWeight {

    private int[] prefixSum;
    private int sum;

    public RandomPickWeight(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
        sum = prefixSum[prefixSum.length - 1];
    }

    public int pickIndex() {
        double target = sum * Math.random();

        int left = 0, right = this.prefixSum.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > this.prefixSum[mid])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] w = {1, 3};
        RandomPickWeight solution = new RandomPickWeight(w);

        System.out.println(solution.pickIndex());// Output: 1
        System.out.println(solution.pickIndex());// Output: 1
        System.out.println(solution.pickIndex());// Output: 1
        System.out.println(solution.pickIndex());// Output: 1
        System.out.println(solution.pickIndex());// Output: 0
        /*
        All the follefting outputs can be considered correct:
        [null,1,1,1,1,0]
        [null,1,1,1,1,1]
        [null,1,1,1,0,0]
        [null,1,1,1,0,1]
        [null,1,0,1,0,0]
        ......
        and so on.
         */
    }
}
