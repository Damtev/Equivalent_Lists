import operations.*;

import java.util.ArrayList;
import java.util.List;

import static operations.Operator.ADD;
import static operations.Operator.MULT;

class Solver {

    private Simplifier simplifier;

    Solver() {
        simplifier = new Simplifier();
    }

    boolean areEquals(String[] tokens1, String[] tokens2) {
        List<EqualityClass<Operation>> first = new ArrayList<>();
        List<EqualityClass<Operation>> second = new ArrayList<>();
        read(tokens1, first);
        read(tokens2, second);
        if (first.size() != second.size()) {
            return false;
        }
        sort(first);
        sort(second);
        for (int i = 0; i < first.size(); i++) {
            EqualityClass<Operation> equalityClass1 = first.get(i);
            EqualityClass<Operation> equalityClass2 = second.get(i);
            if (equalityClass1.getType() != equalityClass2.getType()) {
                return false;
            }
            List<Operation> operations1 = equalityClass1.operations;
            List<Operation> operations2 = equalityClass2.operations;
            if (operations1.size() != operations2.size()) {
                return false;
            }
            for (int j = 0; j < operations1.size(); j++) {
                if (operations1.get(j).operand != operations2.get(j).operand) {
                    return false;
                }
            }
        }

        return true;
    }

    private void read(String[] tokens, List<EqualityClass<Operation>> list) {
        for (String token : tokens) {
            List<Operation> operations = new ArrayList<>();
            Operator type;
            char operator = token.charAt(0);
            int operand = Integer.parseInt(token.substring(1));
            switch (operator) {
                case '+':
                    if (operand == 0) {
                        continue;
                    }
                    type = ADD;
                    List<Integer> deuces = simplifier.getDeuces(operand);
                    for (int deuce : deuces) {
                        operations.add(new Add(deuce));
                    }
                    break;
                default:
                    if (operand == 1) {
                        continue;
                    }
                    type = MULT;
                    List<Integer> factors = simplifier.getFactors(operand);
                    for (int factor : factors) {
                        operations.add(new Mult(factor));
                    }
            }
            if (list.isEmpty() || list.get(list.size() - 1).getType() != type) {
                EqualityClass<Operation> equalityClass = new EqualityClass<>();
                equalityClass.setOperations(operations, type);
                list.add(equalityClass);
            } else {
                for (Operation operation : operations) {
                    list.get(list.size() - 1).put(operation);
                }
            }
        }
    }

    private void sort(List<EqualityClass<Operation>> equalityClasses) {
        for (EqualityClass<Operation> equalityClass : equalityClasses) {
            equalityClass.operations.sort(Operation::compareTo);
        }
    }
}
