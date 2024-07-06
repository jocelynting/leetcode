package math;

public class PassPillow {
    public int passThePillow(int n, int time) {

        int round = n - 1;

        int count = time / round;
        int extra = time % round;

        if (count % 2 == 0) {
            return extra + 1;
        } else {
            return n - extra;
        }
    }

    public static void main(String[] args) {
        PassPillow solution = new PassPillow();

        System.out.println(solution.passThePillow(4, 5));// Output: 2
        System.out.println(solution.passThePillow(3, 2));// Output: 3
    }
}
