package array;

public class FindStudentWillReplaceChalk {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;

        for (int c : chalk) {
            sum += c;
        }

        long rest = k % sum;

        for (int i = 0; i < chalk.length; i++) {
            int num = chalk[i];
            rest -= num;
            if (rest < 0) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        FindStudentWillReplaceChalk solution = new FindStudentWillReplaceChalk();
        int[] chalk1 = {5, 1, 5};
        System.out.println(solution.chalkReplacer(chalk1, 22));// Output: 0

        int[] chalk2 = {3, 4, 1, 2};
        System.out.println(solution.chalkReplacer(chalk2, 25));// Output: 1
    }
}
