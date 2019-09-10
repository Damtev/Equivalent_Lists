import operations.Operation;
import operations.Operator;

import java.util.List;

class EqualityClass<E extends Operation> {

    private List<E> operations;
    private Operator type;

    void put(E operation) {
        type = operation.operator;
        operations.add(operation);
    }

    List<E> getOperations() {
        return operations;
    }

    void setOperations(List<E> operations, Operator type) {
        this.type = type;
        this.operations = operations;
    }

    Operator getType() {
        return type;
    }
}
