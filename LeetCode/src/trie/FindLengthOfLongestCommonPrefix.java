package trie;

import java.util.HashMap;
import java.util.Map;

public class FindLengthOfLongestCommonPrefix {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie t = new Trie();

        for (int num : arr1) {
            t.insert(String.valueOf(num));
        }

        int max = 0;

        for (int num : arr2) {
            int length = t.longestCommonPrefix(String.valueOf(num));
            max = Math.max(max, length);
        }

        return max;
    }

    class Trie {

        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.children.containsKey(ch)) {
                    node.children.put(ch, new TrieNode());
                }
                node = node.children.get(ch);
            }
            node.setEnd();
        }

        public int longestCommonPrefix(String word) {
            TrieNode node = root;
            int length = 0;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.children.containsKey(ch)) {
                    break;
                }
                length++;
                node = node.children.get(ch);
            }

            return length;
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;

        TrieNode() {
            children = new HashMap<>();
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }

    public static void main(String[] args) {
        FindLengthOfLongestCommonPrefix solution = new FindLengthOfLongestCommonPrefix();
        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};
        System.out.println(solution.longestCommonPrefix(arr1, arr2)); // Output: 3

        int[] arr3 = {1, 2, 3};
        int[] arr4 = {4, 4, 4};
        System.out.println(solution.longestCommonPrefix(arr3, arr4)); // Output: 0
    }
}


