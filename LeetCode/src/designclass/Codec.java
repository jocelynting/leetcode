package designclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codec {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
            sb.append(",");
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        String[] result = s.split(",", -1);
        return new ArrayList<>(Arrays.asList(result).subList(0, result.length - 1));
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        List<String> strs = new ArrayList<>();
        strs.add("hello");
        strs.add("world");
        strs.add("");

        String encoded = codec.encode(strs);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = codec.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}
