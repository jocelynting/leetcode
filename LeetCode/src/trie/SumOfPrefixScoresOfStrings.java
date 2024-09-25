package trie;

import java.util.Arrays;

public class SumOfPrefixScoresOfStrings {

    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        Trie t = new Trie();

        for (String w : words) {
            t.insert(w);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = t.count(words[i]);
        }

        return result;
    }

    class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node.get(ch).count++;
                node = node.get(ch);
            }
        }

        public int count(String word) {
            TrieNode node = root;
            int result = 0;
            for (char ch : word.toCharArray()) {
                result += node.get(ch).count;
                node = node.get(ch);
            }

            return result;
        }

    }

    class TrieNode {
        public TrieNode[] children;
        public int count;

        public TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }

        public boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }

        public TrieNode get(char ch) {
            return children[ch - 'a'];
        }
    }

    public static void main(String[] args) {
        SumOfPrefixScoresOfStrings solution = new SumOfPrefixScoresOfStrings();
        String[] words1 = {"abc", "ab", "bc", "b"};
        System.out.println(Arrays.toString(solution.sumPrefixScores(words1))); // Output: [5, 4, 3, 2]

        String[] words2 = {"abcd"};
        System.out.println(Arrays.toString(solution.sumPrefixScores(words2))); // Output: [4]
    }
}
