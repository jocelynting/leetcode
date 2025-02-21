package hash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] wordArray = sentence.split(" ");
        Set<String> dictSet = new HashSet<>(dictionary);

        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = shortestRoot(wordArray[i], dictSet);
        }

        return String.join(" ", wordArray);
    }

    private String shortestRoot(String word, Set<String> dictSet) {
        for (int i = 1; i <= word.length(); i++) {
            String root = word.substring(0, i);
            if (dictSet.contains(root)) {
                return root;
            }
        }
        return word;
    }

    public static void main(String[] args) {
        ReplaceWords solution = new ReplaceWords();

        // Test cases
        List<String> dictionary1 = List.of("cat", "bat", "rat");
        String sentence1 = "the cattle was rattled by the battery";
        System.out.println(solution.replaceWords(dictionary1, sentence1));
        // Output: "the cat was rat by the bat"

        List<String> dictionary2 = List.of("a", "b", "c");
        String sentence2 = "aadsfasf absbs bbab cadsfafs";
        System.out.println(solution.replaceWords(dictionary2, sentence2));
        // Output: "a a b c"
    }
}
