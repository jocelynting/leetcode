package designclass;

public class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch: word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        return searchInNode(word, root);
    }
    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                if (ch == '.') {
                    for (TrieNode child : node.links) {
                        if (child != null && searchInNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    return false;
                }
            } else {
                node = node.get(ch);
            }
        }
        return node.isEnd();
    }
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("pad")); // Output：false
        System.out.println(wordDictionary.search("bad")); // Output：true
        System.out.println(wordDictionary.search(".ad")); // Output：true
        System.out.println(wordDictionary.search("b..")); // Output：true
    }
}

class TrieNode {
   TrieNode[] links;
   boolean isEnd;

   public TrieNode() {
       links = new TrieNode[26];
   }

    public boolean containsKey(char ch) {
        return ch >= 'a' && ch <= 'z' && links[ch - 'a'] != null;
   }

    public void put(char ch, TrieNode node) {
        if (ch >= 'a' && ch <= 'z') {
            links[ch - 'a'] = node;
        }
   }

    public TrieNode get(char ch) {
        return ch >= 'a' && ch <= 'z' ? links[ch - 'a'] : null;
   }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
