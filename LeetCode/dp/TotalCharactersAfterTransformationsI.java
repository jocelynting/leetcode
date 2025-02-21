package dp;

public class TotalCharactersAfterTransformationsI {
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1000000007;
        long[] count = new long[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            long[] tmp = new long[26];
            for (int j = 0; j < 26; j++) {
                if (j == 25) {
                    tmp[0] = (tmp[0] + count[j]) % MOD;
                    tmp[1] = (tmp[1] + count[j]) % MOD;
                } else {
                    tmp[j + 1] = (tmp[j + 1] + count[j]) % MOD;
                }
            }
            count = tmp;
        }

        long result = 0;
        for (long c : count) {
            result = (result + c) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        TotalCharactersAfterTransformationsI solution = new TotalCharactersAfterTransformationsI();
        System.out.println(solution.lengthAfterTransformations("abcyy", 2)); // Output: 7
        System.out.println(solution.lengthAfterTransformations("azbk", 1)); // Output: 5
    }
}
