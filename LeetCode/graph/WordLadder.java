package graph;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return ladderLengthBySimplifiedBFS(beginWord, endWord, wordList);
//        return ladderLengthByGraph(beginWord, endWord, wordList);
    }
    public int ladderLengthBySimplifiedBFS(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                char[] curChars = cur.toCharArray();

                for (int j = 0; j < curChars.length; j++) {
                    char original = curChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        curChars[j] = c;
                        String newWord = new String(curChars);

                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    curChars[j] = original;
                }
            }
            level++;
        }

        return 0;
    }

    public int ladderLengthByGraph(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> graph = buildGraph(beginWord, wordSet);

        return bfs(beginWord, endWord, graph);
    }

    private Map<String, List<String>> buildGraph(String beginWord, Set<String> wordSet) {
        Map<String, List<String>> graph = new HashMap<>();
        wordSet.add(beginWord);

        for (String word : wordSet) {
            graph.put(word, new ArrayList<>());
        }

        for (String word : wordSet) {
            char[] wordArray = word.toCharArray();
            for (int i = 0; i < wordArray.length; i++) {
                char originalChar = wordArray[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == originalChar) continue;
                    wordArray[i] = c;
                    String newWord = new String(wordArray);
                    if (wordSet.contains(newWord)) {
                        graph.get(word).add(newWord);
                    }
                }
                wordArray[i] = originalChar;
            }
        }

        return graph;
    }

    private int bfs(String beginWord, String endWord, Map<String, List<String>> graph) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                List<String> neighbors = graph.get(currentWord);
                for (String neighbor : neighbors) {
                    if (neighbor.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder solution = new WordLadder();
//        List<String> wordList1 = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
//        System.out.println(solution.ladderLength("hit", "cog", wordList1)); // Output: 5
//
//        List<String> wordList2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
//        System.out.println(solution.ladderLength("hit", "cog", wordList2)); // Output: 0

        List<String> wordList3 = Arrays.asList("hot", "dog");
        System.out.println(solution.ladderLength("hot", "dog", wordList3)); // Output: 0
    }
}
