package hash;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String string : strs) {
            char[] letters = string.toCharArray();
            Arrays.sort(letters);
            String sortedString = new String(letters);

            map.computeIfAbsent(sortedString, k -> new ArrayList<>()).add(string);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();

        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result1 = solution.groupAnagrams(test1);
        System.out.println(result1);  // Output: [[bat], [nat, tan], [ate, eat, tea]]

        String[] test2 = {""};
        List<List<String>> result2 = solution.groupAnagrams(test2);
        System.out.println(result2);  // Output: [[""]]

        String[] test3 = {"a"};
        List<List<String>> result3 = solution.groupAnagrams(test3);
        System.out.println(result3);  // Output: [["a"]]
    }
}
