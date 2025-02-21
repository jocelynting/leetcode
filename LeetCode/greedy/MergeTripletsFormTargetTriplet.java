package greedy;

public class MergeTripletsFormTargetTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int firstMax = 0, secondMax = 0, thirdMax = 0;
        int t1 = target[0], t2 = target[1], t3 = target[2];

        for (int[] tri : triplets) {
            int a = tri[0], b = tri[1], c = tri[2];

            if (a <= t1 && b <= t2 && c <= t3) {
                firstMax = Math.max(firstMax, a);
                secondMax = Math.max(secondMax, b);
                thirdMax = Math.max(thirdMax, c);
            }
        }

        return firstMax >= t1 && secondMax >= t2 && thirdMax >= t3;
    }

    public static void main(String[] args) {
        MergeTripletsFormTargetTriplet solution = new MergeTripletsFormTargetTriplet();
        int[][] triplets = {{2, 5, 3}, {1, 8, 4}, {1, 7, 5}};
        int[] target = {2, 7, 5};
        System.out.println(solution.mergeTriplets(triplets, target)); // Output: true
    }
}
