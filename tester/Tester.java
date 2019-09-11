import org.junit.Test;

import java.util.Random;
import static junit.framework.TestCase.assertEquals;

public class Tester {

    private static Random random = new Random();

    private static final int TESTS_NUMBER = 50;

    private static final int MAX_IN_SUM = 50;

    private static final int MAX_IN_MULT = 6;

    private static final int MAX_SUM_LEN = 500;

    private static final int MAX_MULT_LEN = 20;

    @Test
    public void allTests() {
        onlySum();
        onlyMult();
        all();
    }

    @Test
    public void onlySum() {
        test(new String[]{"+"}, MAX_IN_SUM, MAX_SUM_LEN);
    }

    @Test
    public void onlyMult() {
        test(new String[]{"*"}, MAX_IN_MULT, MAX_MULT_LEN);
    }

    @Test
    public void all() {
        test(new String[]{"+", "*"}, MAX_IN_MULT, MAX_MULT_LEN);
    }

    private static void test(String[] operationsPool, int max, int len) {
        for (int i = 0; i < TESTS_NUMBER; i++) {
            long result1 = random.nextInt(max) + 1;
            long result2 = result1;
            String[] list1 = new String[len];
            String[] list2 = new String[len];
            for (int j = 0; j < len; j++) {
                long randomNumber = random.nextInt(max) + 1;
                String operation = operationsPool[random.nextInt(operationsPool.length)];
                list1[j] = operation + randomNumber;
            }
            System.arraycopy(list1, 0, list2, 0, len);
            shuffleList(list2);
            result1 = calc(list1, result1);
            result2 = calc(list2, result2);
            assertEquals(Solver.areEqual(list1, list2), result1 == result2);
        }
    }

    private static void shuffleList(String[] tokens) {
        for (int i = tokens.length - 1; i > 0; i--) {
            int pos = random.nextInt(i + 1);
            String temp = tokens[pos];
            tokens[pos] = tokens[i];
            tokens[i] = temp;
        }
    }

    private static long calc(String[] tokens, long result) {
        for (String token : tokens) {
            String operation = token.substring(0, 1);
            long number = Long.parseLong(token.substring(1));
            switch (operation) {
                case "+":
                    result += number;
                    break;
                case "*":
                    result *= number;
                    break;
            }
        }

        return result;
    }
}
