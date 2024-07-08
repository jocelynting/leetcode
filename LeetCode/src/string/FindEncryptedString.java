package string;

public class FindEncryptedString {
    public String getEncryptedString(String s, int k) {
        int index = k % s.length();
        String s1 = s.substring(index, s.length());
        String s2 = s.substring(0, index);

        return s1 + s2;
    }

    public static void main(String[] args) {
        FindEncryptedString solution = new FindEncryptedString();
        System.out.println(solution.getEncryptedString("dart", 3));// Output: "tdar"
        System.out.println(solution.getEncryptedString("aaa", 1));// Output: "aaa"
        System.out.println(solution.getEncryptedString("byd", 4));// Output: "ydb"
    }
}
