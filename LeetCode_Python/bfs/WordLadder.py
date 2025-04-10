from collections import deque


class WordLadder:
    def ladderLength(self, beginWord: str, endWord: str, wordList: list[str]) -> int:
        word_set = set(wordList)
        if endWord not in word_set:
            return 0

        queue = deque([(beginWord, 1)])
        if beginWord in word_set:
            word_set.remove(beginWord)

        while queue:
            cur, level = queue.popleft()
            if cur == endWord:
                return level

            for i in range(len(cur)):
                for c in "abcdefghijklmnopqrstuvwxyz":
                    if c == cur[i]:
                        continue
                    next_word = cur[:i] + c + cur[i + 1 :]
                    if next_word in word_set:
                        word_set.remove(next_word)
                        queue.append((next_word, level + 1))

        return 0


# Time Complexity: O(n * m * 26), where n is the number of words in the wordList and m is the length of each word.
# Space Complexity: O(n), where n is the number of words in the wordList, for storing the word_set and the queue.


if __name__ == "__main__":
    solution = WordLadder()

    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot", "dot", "dog", "lot", "log", "cog"]
    print("Expected Output : 5")
    print("Actual Output : ", solution.ladderLength(beginWord, endWord, wordList))

    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot", "dot", "dog", "lot", "log"]
    print("Expected Output : 0")
    print("Actual Output : ", solution.ladderLength(beginWord, endWord, wordList))
