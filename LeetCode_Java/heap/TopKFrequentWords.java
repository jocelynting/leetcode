package heap;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int count1 = map.get(s1);
                int count2 = map.get(s2);
                if (count1 == count2) {
                    return s2.compareTo(s1);
                }

                return count1 - count2;
            }
        });

        for (String word : map.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentWords solution = new TopKFrequentWords();

        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;
        System.out.println(solution.topKFrequent(words1, k1));  // Output: ["i", "love"]

        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 4;
        System.out.println(solution.topKFrequent(words2, k2));  // Output: ["the", "is", "sunny", "day"]

        String[] words3 = {"i", "love", "leetcode", "i", "love", "coding", "coding"};
        int k3 = 3;
        System.out.println(solution.topKFrequent(words3, k3));  // Output: ["i", "love", "coding"]
    }

}
