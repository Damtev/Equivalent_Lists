import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_NUMBER = 1_000_000;

    private static final String DELIMETERS = "+*";

    private static final String REGEXP = "([" + DELIMETERS + "]\\d+)+";

    private static void validateInput(String[] args) {
        if (args.length != 2) {
            showUsage();
            throw new IllegalArgumentException();
        }
        Objects.requireNonNull(args[0]);
        Objects.requireNonNull(args[1]);
        if (!args[0].matches(REGEXP) || !args[1].matches(REGEXP)) {
            System.out.println("Invalid input, please check README");
            throw new IllegalArgumentException();
        }
        if (args[0].length() != args[1].length()) {
            System.out.println("Lists have different operations numbers");
            throw new IllegalArgumentException();
        }
    }

    private static void showUsage() {
        System.out.println("Usage: ./run.sh <list1> <list2>" );
    }

    public static List<String> parse(String list) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(list, DELIMETERS, true);
        while (tokenizer.hasMoreTokens()) {
            String delim = tokenizer.nextToken();
            String stringNumber = tokenizer.nextToken();
            if (stringNumber.length() > 6) {
                System.out.println("Numbers are too big");
                throw new IllegalArgumentException();
            }
            tokens.add(delim + stringNumber);
        }

        return tokens;
    }

    public static void main(String[] args) {
        validateInput(args);
        List<List<String>> tokensList = new ArrayList<>();
        for (String list : args) {
            tokensList.add(parse(list));
        }
        System.out.println(Solver.areEqual(tokensList.get(0).toArray(new String[0]),
                tokensList.get(1).toArray(new String[0])));
    }
}
