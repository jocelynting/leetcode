package trie;

import java.util.List;

public class ReplaceWords {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char ch: word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.word = word;
    }

    private String prefix(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return word;
            }
            node = node.children[c - 'a'];
            if (node.word != null) {
                return node.word;
            }
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String word: dictionary) {
            insert(root, word);
        }

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word: words) {
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(prefix(root, word));
        }

        return sb.toString();
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
