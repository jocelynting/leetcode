package bit;

public class CountTripletsEqualXOR {

    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] prefixXOR = new int[n + 1];

        for (int i = 1; i <= n ; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i - 1];
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {
                if (prefixXOR[i] == prefixXOR[k + 1]) {
                    result += (k - i);
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        CountTripletsEqualXOR solution = new CountTripletsEqualXOR();
        int[] arr1 = {2, 3, 1, 6, 7};
        System.out.println(solution.countTriplets(arr1));  // Output: 4
        int[] arr2 = {1, 1, 1, 1, 1};
        System.out.println(solution.countTriplets(arr2));  // Output: 10
    }
}
