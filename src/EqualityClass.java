import operations.Operation;
import operations.Operator;

import java.util.List;

public class EqualityClass<E extends Operation> {

    public List<E> operations;
    private Operator type;

    public void put(E operation) {
        type = operation.operator;
        operations.add(operation);
    }

    public void setOperations(List<E> operations, Operator type) {
        this.type = type;
        this.operations = operations;
    }

    public Operator getType() {
        return type;
    }
}
