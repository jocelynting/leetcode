package string;

public class MinimumDeletionsMakeStringBalanced {

    public int minimumDeletions(String s) {
        int count = 0, result = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                count++;
            } else {
                result = Math.min(result + 1, count);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumDeletionsMakeStringBalanced solution = new MinimumDeletionsMakeStringBalanced();

        System.out.println(solution.minimumDeletions("aababbab"));  // Output: 2
        System.out.println(solution.minimumDeletions("bbaaaaabb"));  // Output: 2
    }
}
