package designclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();
        int index = 0;

        while (index < s.length()) {
            int position = s.indexOf('#', index);
            int length = Integer.parseInt(s.substring(index, position));
            String str = s.substring(position + 1, position + 1 + length);
            strs.add(str);
            index = position + 1 + length;
        }

        return strs;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        List<String> strs = Arrays.asList("hello", "world", "leetcode");
        String encoded = codec.encode(strs);
        System.out.println("Encoded: " + encoded); // Encoded string
        List<String> decoded = codec.decode(encoded);
        System.out.println("Decoded: " + decoded); // Decoded list of strings
    }
}
