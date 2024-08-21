package hash;

import java.util.TreeSet;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);

        Long cur = 1L;
        for (int i = 0; i < n; i++) {
            cur = set.pollFirst();
            set.add(cur * 2);
            set.add(cur * 3);
            set.add(cur * 5);
        }

        return cur.intValue();
    }

    public static void main(String[] args) {
        UglyNumberII solution = new UglyNumberII();
        System.out.println(solution.nthUglyNumber(10));// Output: 12
        System.out.println(solution.nthUglyNumber(1));// Output: 1
    }
}
