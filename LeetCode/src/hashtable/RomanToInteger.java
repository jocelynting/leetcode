package hashtable;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int i = 0;
        int result = 0;

        while (i < s.length()) {

            if (i < s.length() - 1) {
                String str2 = s.substring(i, i + 2);
                if (map.containsKey(str2)) {
                    result += map.get(str2);
                    i += 2;
                    continue;
                }
            }

            String str1 = s.substring(i, i + 1);
            result += map.get(str1);
            i += 1;
        }

        return result;

    }

    public static void main(String[] args) {
        RomanToInteger solution = new RomanToInteger();
        String s1 = "III";
        String s2 = "LVIII";
        String s3 = "MCMXCIV";
        System.out.println(solution.romanToInt(s1));// Output: 3
        System.out.println(solution.romanToInt(s2));// Output: 58
        System.out.println(solution.romanToInt(s3));// Output: 1994
    }
}
