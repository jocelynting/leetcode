package string;

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 1) {
            return strs[0];
        }

        String prefix = strs[0];

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return prefix.substring(0, i);
                }
            }
        }

        return prefix;

//        Arrays.sort(strs);
//
//        String first = strs[0];
//        String last = strs[strs.length - 1];
//
//        int length = Math.min(first.length(), last.length());
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < length; i++) {
//            if (first.charAt(i) == last.charAt(i)) {
//                sb.append(first.charAt(i));
//            } else {
//                break;
//            }
//        }
//
//        return sb.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] strs1 = {"flower","flow","flight"};
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(solution.longestCommonPrefix(strs1));// Output: "fl"
        System.out.println(solution.longestCommonPrefix(strs2));// Output: ""

    }
}
