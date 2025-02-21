package slidingwindow;

public class TakeKEachCharacterFromLeftAndRight {
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int c : count) {
            if (c < k) {
                return -1;
            }
        }

        int[] windowCount = new int[3];
        int left = 0, maxWindow = 0;
        int n = s.length();

        for (int right = 0; right < n; right++) {
            windowCount[s.charAt(right) - 'a']++;

            while (left <= right && (count[0] - windowCount[0] < k || count[1] - windowCount[1] < k || count[2] - windowCount[2] < k)) {
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return n - maxWindow;
    }

    public static void main(String[] args) {
        TakeKEachCharacterFromLeftAndRight solution = new TakeKEachCharacterFromLeftAndRight();
        System.out.println(solution.takeCharacters("aabaaaacaabc", 2)); // Output: 8
        System.out.println(solution.takeCharacters("a", 1)); // Output:-1
    }
}
