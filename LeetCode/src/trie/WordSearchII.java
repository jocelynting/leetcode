package trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtracking(board, i, j, root, result);
            }
        }

        return result;
    }

    private void backtracking(char[][] board, int row, int col, TrieNode node, List<String> result) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        char ch = board[row][col];
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';

        backtracking(board, row - 1, col, node, result);
        backtracking(board, row + 1, col, node, result);
        backtracking(board, row, col - 1, node, result);
        backtracking(board, row, col + 1, node, result);

        board[row][col] = ch;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char ch : w.toCharArray()) {
                if (p.children[ch - 'a'] == null) {
                    p.children[ch - 'a'] = new TrieNode();
                }
                p = p.children[ch - 'a'];
            }
            p.word = w;
        }

        return root;
    }

    public static void main(String[] args) {
        WordSearchII solution = new WordSearchII();
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(solution.findWords(board, words));// Output: ["eat","oath"]
    }
}
