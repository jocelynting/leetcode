package twopoint;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] strs = s.toCharArray();

        int left = 0, right = strs.length - 1;

        while (left < right) {
            while (left < right && !isVowel(strs[left])) {
                left++;
            }

            while (left < right && !isVowel(strs[right])) {
                right--;
            }

            if (left < right) {
                char temp = strs[left];
                strs[left] = strs[right];
                strs[right] = temp;
                left++;
                right--;
            }
        }

        return new String(strs);
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString solution = new ReverseVowelsOfAString();
        System.out.println(solution.reverseVowels("IceCreAm")); // Output: "AceCreIm"
        System.out.println(solution.reverseVowels("leetcode")); // Output: "leotcede"
    }
}
