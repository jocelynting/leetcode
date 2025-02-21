package greedy;

public class ReduceNumberBinaryRepresentationToOne {
    public int numSteps(String s) {

        int step = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0' + carry;
            if (bit == 1) {
                carry = 1;
                step += 2;
            } else {
                step += 1;
            }
        }

        return step + carry;

    }

    public static void main(String[] args) {
        ReduceNumberBinaryRepresentationToOne solution = new ReduceNumberBinaryRepresentationToOne();

        String s1 = "1101";
        System.out.println(solution.numSteps(s1)); // Output: 6

        String s2 = "10";
        System.out.println(solution.numSteps(s2)); // Output: 1

        String s3 = "1";
        System.out.println(solution.numSteps(s3)); // Output: 0
    }
}
