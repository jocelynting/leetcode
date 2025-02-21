package string;

public class NumberOfSeniorCitizens {
    public int countSeniors(String[] details) {
        int result = 0;

        for (String info : details) {
            String age = info.substring(11, 13);
            if (Integer.parseInt(age) > 60) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfSeniorCitizens solution = new NumberOfSeniorCitizens();

        String[] details1 = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
        System.out.println(solution.countSeniors(details1));// Output: 2

        String[] details2 = {"1313579440F2036", "2921522980M5644"};
        System.out.println(solution.countSeniors(details2));// Output: 0
    }
}
