package packages.data_structures.exceptions;

public class IllegalCharacterException extends RuntimeException {
    @Override
    public String toString() {
        return "IllegalCharacterException - only letters from the English alphabet are allowed.";
    }
}
