package twopoint;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

//        String result = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {

            char left = Character.toLowerCase(s.charAt(l));
            char right = Character.toLowerCase(s.charAt(r));

            if (!Character.isLetterOrDigit(left)){
                l++;
            } else if (!Character.isLetterOrDigit(right)) {
                r--;
            } else if (left != right){
                return false;
            } else {
                l++;
                r--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();

        // Test cases
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";

        System.out.println("Is '" + s1 + "' a valid palindrome? " + solution.isPalindrome(s1)); // Output: true
        System.out.println("Is '" + s2 + "' a valid palindrome? " + solution.isPalindrome(s2)); // Output: false
    }
}
