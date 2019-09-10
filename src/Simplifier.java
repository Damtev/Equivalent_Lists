import java.util.ArrayList;
import java.util.List;

class Simplifier {

    private final int MAX_NUMBER;
    private int[] minPrimeDividers;
    private List<Integer> primeNumbers;

    Simplifier() {
        MAX_NUMBER = Main.MAX_NUMBER;
        minPrimeDividers = new int[MAX_NUMBER + 1];
        primeNumbers = new ArrayList<>();
        sieve();
    }

    private void sieve() {
        for (int number = 2; number <= MAX_NUMBER; number++) {
            if (minPrimeDividers[number] == 0) {
                minPrimeDividers[number] = number;
                primeNumbers.add(number);
            }
            for (int j = 0; j < primeNumbers.size() && primeNumbers.get(j) <= minPrimeDividers[number]; j++) {
                int next = number * primeNumbers.get(j);
                if (next > MAX_NUMBER) {
                    break;
                }
                minPrimeDividers[next] = primeNumbers.get(j);
            }
        }
    }

    List<Integer> getDeuces(int number) {
        List<Integer> deuces = new ArrayList<>();
        while (number > 2) {
            deuces.add(2);
            number -= 2;
        }

        deuces.add(number);
        return deuces;
    }

    List<Integer> getFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        while (number != 1) {
            factors.add(minPrimeDividers[number]);
            number /= minPrimeDividers[number];
        }

        return factors;
    }
}
