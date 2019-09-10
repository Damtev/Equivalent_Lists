import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_NUMBER = 1_000_000;
    private static final String DELIMETERS = "+*";
    private static final String REGEXP = "([" + DELIMETERS + "]\\d+)+";

    private static boolean validate(String s1, String s2) {
        if (!s1.matches(REGEXP) || !s2.matches(REGEXP)) {
            System.out.println("Invalid input, please check README");
            return false;
        }
        if (s1.length() != s2.length()) {
            System.out.println("Lists have different operations numbers");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Enter two operation lists separated by whitespace");
            return;
        }
        String s1 = args[0];
        String s2 = args[1];
        if (!validate(s1, s2)) {
            return;
        }
        List<List<String>> tokensList = new ArrayList<>();
        for (String list : args) {
            StringTokenizer tokenizer = new StringTokenizer(list, DELIMETERS, true);
            tokensList.add(new ArrayList<>());
            while (tokenizer.hasMoreTokens()) {
                String delim = tokenizer.nextToken();
                String stringNumber = tokenizer.nextToken();
                if (stringNumber.length() > 6) {
                    System.out.println("Numbers are too big");
                    return;
                }
                tokensList.get(tokensList.size() - 1).add(delim + stringNumber);
            }
        }
        Solver solver = new Solver();
        System.out.println(solver.areEquals(tokensList.get(0).toArray(new String[0]), tokensList.get(1).toArray(new String[0])));
    }
}
