package backtracking;

public class MaximumScoreWordsFormedByLetters {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
       int[] letterCount = new int[26];
       for (char l: letters) {
           letterCount[l - 'a']++;
       }

       return backtracking(words, letterCount, score, 0);
    }

    private int backtracking(String[] words, int[] letterCount, int[] score, int start) {
        if (start == words.length) {
            return 0;
        }

        int maxScore = backtracking(words, letterCount, score, start + 1);

        int[] wordCount = new int[26];
        for (char l: words[start].toCharArray()) {
            wordCount[l - 'a']++;
        }

        boolean canForm = true;
        for (int i = 0; i < 26; i++) {
            if (wordCount[i] > letterCount[i]) {
                canForm = false;
                break;
            }
        }

        if (canForm) {
            for (int i = 0; i < 26; i++) {
                letterCount[i] -= wordCount[i];
            }

            int curScore = 0;
            for (char l: words[start].toCharArray()) {
                curScore += score[l - 'a'];
            }

            maxScore = Math.max(maxScore, curScore + backtracking(words, letterCount, score, start + 1));

            for (int i = 0; i < 26; i++) {
                letterCount[i] += wordCount[i];
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        MaximumScoreWordsFormedByLetters solution = new MaximumScoreWordsFormedByLetters();

        String[] words1 = {"dog", "cat", "dad", "good"};
        char[] letters1 = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
        int[] score1 = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(solution.maxScoreWords(words1, letters1, score1)); // Output: 23


        String[] words2 = {"xxxz", "ax", "bx", "cx"};
        char[] letters2 = {'z', 'a', 'b', 'c', 'x', 'x', 'x'};
        int[] score2 = {4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10};
        System.out.println(solution.maxScoreWords(words2, letters2, score2)); // Output: 27
    }
}
