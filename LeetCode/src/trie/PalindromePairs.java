package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            insertWord(root, words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            searchWords(root, words[i], i, result);
        }

        return result;
    }

    static class TrieNode {
        TrieNode[] children;
        List<Integer> palindromeSuffixes; // Stores indices of words with palindromic suffixes
        int index;

        TrieNode() {
            children = new TrieNode[26];
            palindromeSuffixes = new ArrayList<>();
            index = -1; // -1 indicates no word ends here
        }
    }

    private void insertWord(TrieNode root, String word, int index) {
        TrieNode node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);

            if (isPalindrome(word, 0, i)) {
                node.palindromeSuffixes.add(index);
            }

            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.index = index;
        node.palindromeSuffixes.add(index);
    }

    private void searchWords(TrieNode root, String word, int index, List<List<Integer>> result) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            // If we find a node which has a word end and the remaining part of the current word is a palindrome
            if (node.index >= 0 && node.index != index && isPalindrome(word, i, word.length() - 1)) {
                result.add(Arrays.asList(index, node.index));
            }

            char c = word.charAt(i);
            node = node.children[c - 'a'];
            if (node == null) {
                return; // No further path in Trie
            }
        }

        // If the whole word is traversed, check for remaining palindromic suffixes
        for (int palindromeIndex : node.palindromeSuffixes) {
            if (index != palindromeIndex) {
                result.add(Arrays.asList(index, palindromeIndex));
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePairs solution = new PalindromePairs();
        String[] words1 = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(solution.palindromePairs(words1));// Output: [[0,1],[1,0],[3,2],[2,4]]

        String[] words2 = {"bat", "tab", "cat"};
        System.out.println(solution.palindromePairs(words2));// Output: [[0,1],[1,0]]
    }
}
