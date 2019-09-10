package operations;

public abstract class Operation implements Comparable<Operation> {

    public Operator operator;
    public int operand;

    public Operation(int operand) {
        this.operand = operand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operation operation = (Operation) o;

        if (operand != operation.operand) return false;
        return operator == operation.operator;
    }

    @Override
    public int hashCode() {
        int result = operator != null ? operator.hashCode() : 0;
        result = 31 * result + operand;
        return result;
    }

    @Override
    public int compareTo(Operation operation) {
        return Integer.compare(operand, operation.operand);
    }
}
