package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtracking(result, digits, new StringBuilder(), 0, map);

        return result;
    }

    private void backtracking(List<String> result, String digits, StringBuilder current, int index, Map<Character,String> map) {
        if (current.length() == digits.length()) {
            result.add(current.toString());
            System.out.println(result);
            return;
        }

        char ch = digits.charAt(index);
        String letters = map.get(ch);

        for (char l: letters.toCharArray()) {
            current.append(l);
            backtracking(result, digits, current, index + 1, map);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations solution = new LetterCombinations();
        String digits = "23";
        List<String> combinations = solution.letterCombinations(digits);
        System.out.println("Letter combinations for " + digits + ": " + combinations);
    }
}
