package packages.data_structures.exceptions;

public class EmptyQueueException extends Exception {
    @Override
    public String toString() {
        return "EmptyQueueException - There is nothing to remove();";
    }
}
